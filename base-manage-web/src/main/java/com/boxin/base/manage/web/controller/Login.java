package com.boxin.base.manage.web.controller;

import com.boxin.base.common.util.JsonUtil;
import com.boxin.base.common.validation.ValidationCode;
import com.boxin.base.service.manage.user.UserService;
import com.boxin.base.webmodel.ResultData;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * login controller
 * Created by zy
 * Date  2015/4/16.
 */
@Controller
@RequestMapping(value="/login")
public class Login {

    Log logger = LogFactory.getLog(Login.class);
    @Autowired
    UserService userService;

    @RequestMapping(value="/valCode")
    public void getCode(HttpServletRequest request,HttpServletResponse response){
        try {
            ValidationCode.pushValidationCode(request,response,"validatedCode");
        } catch (IOException e) {
            logger.error(e.getMessage(),e);
        }
    }

    /**
     * 跳转至登陆页面
     * @return
     */
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value="/index")
    public String index() {
        return "login";
    }
    /**
     * 登陆验证
     * @param request
     * @return
     */
    @RequestMapping(value="/adoLogin",method = RequestMethod.POST)
    public @ResponseBody String adoLogin(HttpServletRequest request){
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String code = request.getParameter("code");

        ResultData resultData = ResultData.newInstance();

        //驗證碼验证
        boolean b = ValidationCode.validate(request,"validatedCode",code);
        if(!b){
            resultData.setAsFailure();
            resultData.setMessage("1");
            resultData.addMeta("url","login");
            resultData.addMeta("message","1");//验证码错误
            return JsonUtil.obj2Json(resultData);
        }

        //驗證用戶名與密碼是否不為空
        if(StringUtils.isEmpty(name)){
            resultData.setAsFailure();
            resultData.setMessage("1");
            resultData.addMeta("url","login");
            resultData.addMeta("message","2");//用户名异常
            return JsonUtil.obj2Json(resultData);
        }
        if( StringUtils.isEmpty(password)){
            resultData.setAsFailure();
            resultData.setMessage("1");
            resultData.addMeta("url","login");
            resultData.addMeta("message","3");//密码异常
            return JsonUtil.obj2Json(resultData);
        }

        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name, password);
        token.setRememberMe(true);

        try {
            currentUser.login(token);
        }catch(UnknownAccountException uae){
            resultData.setAsFailure();
            resultData.setMessage("1");
            resultData.addMeta("url","login");
            resultData.addMeta("message", "4");//未知账户
            return JsonUtil.obj2Json(resultData);
        }catch(IncorrectCredentialsException ice){
            resultData.setAsFailure();
            resultData.setMessage("1");
            resultData.addMeta("url","login");
            resultData.addMeta("message", "3");//密码异常
            return JsonUtil.obj2Json(resultData);
        }catch(LockedAccountException lae){
            resultData.setAsFailure();
            resultData.setMessage("1");
            resultData.addMeta("url","login");
            resultData.addMeta("message", "5");//账户已锁
            return JsonUtil.obj2Json(resultData);
        }catch(ExcessiveAttemptsException eae){
            resultData.setAsFailure();
            resultData.setMessage("1");
            resultData.addMeta("url","login");
            resultData.addMeta("message", "6");//登陆错误次数过多
            return JsonUtil.obj2Json(resultData);
        }catch(AuthenticationException ae){
            resultData.setAsFailure();
            resultData.setMessage("1");
            resultData.addMeta("url","login");
            resultData.addMeta("message", "7");//用户名或密码不正确
            return JsonUtil.obj2Json(resultData);
        }

        if(currentUser.isAuthenticated()){
            //设置用户session
            Session session = currentUser.getSession();
            Map<Object,Object> map = new HashMap<Object, Object>();
            map.put("name", name);
            session.setAttribute("_USERINFO", map);
            logger.info("用户" + name + "成功登陆！");
            resultData.setAsSuccess();
            resultData.setMessage("0");
            resultData.addMeta("url", "main");
            resultData.addMeta("message", "0"); //登陆成功
        }else{
            token.clear();
            resultData.setAsFailure();
            resultData.setMessage("1");
            resultData.addMeta("url", "login");
            resultData.addMeta("message", "7"); //用户名或密码不正确
        }

        return JsonUtil.obj2Json(resultData);
    }

    /**
     * 用户退出登陆
     * @return
     */
    @RequestMapping(value="/logout")
    public String logout() {
        //
        String redirectLogin = "redirect:../../";//login";
        //
        Subject subject = null;
        String username = null;
        try {
            subject = SecurityUtils.getSubject();
            Session session = subject.getSession();
            if(session == null){
                return redirectLogin;
            }
            Map<String,String> map = (Map)session.getAttribute("_USERINFO");
            if(map == null){
                return redirectLogin;
            }
            username = map.get("name");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return redirectLogin;
        }
        if (subject.isAuthenticated()) {
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
            logger.info("用户"+username+"已经退出！");
        }
        return redirectLogin;
    }
    
    /**
     * 密码修改
     */
    @RequestMapping(value="/modifyPass",method = RequestMethod.POST)
    public @ResponseBody boolean modifyPass(HttpServletRequest request){
    	String password = request.getParameter("password");
    	Subject subject = null;
    	subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
    	Map<String,Object> map = (Map<String, Object>) session.getAttribute("_USERINFO");
    	String name = (String) map.get("name");
    	String shapassword = new SimpleHash("SHA-256",password, name,1024).toHex();
    	boolean b;
		try {
			b = userService.updatePwd(name, shapassword);
		} catch (Exception e) {
			b = false;
			logger.error(e.getMessage(),e);
		}
        return b;
    }
    
    @RequestMapping(value="/getUserName",method = RequestMethod.POST)
    public @ResponseBody String getUserName(){
    	Subject subject = null;
    	subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Map<String,Object> map = (Map<String, Object>) session.getAttribute("_USERINFO");
    	String name = (String) map.get("name");
    	return name;
    }
}
