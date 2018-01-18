package com.boxin.base.manage.web.controller;


import com.boxin.base.common.util.JsonUtil;
import com.boxin.base.service.manage.user.PermissionService;
import com.boxin.base.model.ManagePermission;

import java.util.List;

import com.boxin.base.webmodel.ResultData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

/**
 * 主界面加载控制
 * Created by zy on 2015/4/17.
 */
@Controller
@RequestMapping(value="/main")
public class Main {

    Log logger = LogFactory.getLog(Main.class);
    @Autowired
    private PermissionService permissionService;
    /**
     * 请求主界面
     * @return
     */
    @RequestMapping(value="/main",method = RequestMethod.GET)
    public String main() {
        return "main";
    }


    /**
     * 获取用户菜单
     * @return
     */
    @RequestMapping(value="getUserMenu")
    @ResponseBody
    public ResultData getUserMenu(){
        List<ManagePermission> mPermissionList = null;

        ResultData resultData = ResultData.newInstance();
        try {
            mPermissionList = permissionService.selectAllMenu();
        } catch (Exception e) {
            return resultData;
        }
        Subject subject = SecurityUtils.getSubject();
        isUserMenu(mPermissionList,subject);
        String menu = JsonUtil.list2Json(mPermissionList);
        menu = menu.replace("service:","");
        menu = menu.replace(".","/");
        menu = menu.replace("/list",".list");
        menu = menu.replace("/html",".html");
        menu = menu.replace("name","text");
        //
        resultData.setAsSuccess();
        resultData.setData(menu);
        return resultData;
    }

    /**
     * 判断是否为用户权限允许的菜单
     * @param mPermissionList
     * @param subject
     */
    public void isUserMenu(List<ManagePermission> mPermissionList,Subject subject){
        for(int i=0;i<mPermissionList.size();i++){
            ManagePermission permission = mPermissionList.get(i);
//            if(subject.isPermitted(permission.getCode()) && permission.getStatus() == 1){
//                isUserMenu(permission.getChildren(),subject);
//            }else{
//                mPermissionList.remove(i);
//                i--;
//            }
            if(!subject.isPermitted(permission.getCode()) || permission.getStatus() != 1){
                mPermissionList.remove(i);
                i--;
            }
        }
    }


    /**
     * 请求菜单设置界面
     * @return
     */
    @RequestMapping(value="/sys/setmenu",method = RequestMethod.GET)
    public String setMenu(){
        return "sys/setmenu";
    }

    /**
     * 请求角色权限界面
     * @return
     */
    @RequestMapping(value="/sys/rolepermission",method =RequestMethod.GET)
    public String setRolePerview(){
        return "sys/rolepermission";
    }


    /**
     * 请求用户角色界面
     * @return
     */
    @RequestMapping(value="/sys/userole",method = RequestMethod.GET)
    public String setUseRole(){
        return "sys/userole";
    }


    /**
     * 请求文件上传界面
     * @return
     */
    @RequestMapping(value="/upload/upload",method = RequestMethod.GET)
    public String getUpload(){
        return "upload/upload";
    }


    /**
     * 用户认证审核界面
     * @return
     */
    @RequestMapping(value="/auth/userauth",method = RequestMethod.GET)
    public String getUserAuthHtml(){
        return "auth/userauth";
    }

    /**
     * 机构认证审核界面
     * @return
     */
    @RequestMapping(value="/auth/orgauth",method = RequestMethod.GET)
    public String getOrgAuthHtml(){
        return "auth/orgauth";
    }
    
    
    /**
     * 评价主页面
     * @return
     */
    @RequestMapping(value="/comment/comment",method = RequestMethod.GET)
    public String comment(){
        return "comment/comment";
    }

    /**
     * 返回轮播图管理界面
     * @return
     */
    @RequestMapping(value="/banner/bannermanage",method = RequestMethod.GET)
    public String getBannerHtml(){
        return "banner/bannermanage";
    }

    /**
     * 返回文章管理界面
     * @return
     */
    @RequestMapping(value = "/article/article",method = RequestMethod.GET)
    public String getArticleHtml(){
        return "article/article";
    }

    /**
     * 返回银行卡界面
     * @return
     */
    @RequestMapping(value = "bank/bank.html",method = RequestMethod.GET)
    public String getBankHtml(){ return "bank/bank.html";}


    @RequestMapping(value="/article/controller.php")
    public ModelAndView getjspController(){
        ModelAndView modelAndView = new ModelAndView();
        InternalResourceView view = new InternalResourceView("/plugins/ueditor/jsp/controller.jsp");

        modelAndView.setView(view);
        return  modelAndView;
    }

    @RequestMapping(value={"/portal/queryUnClaim.json","/portal/queryClanimForTodoTasks.json","/portal/queryFinished.json"})
    public @ResponseBody String getdata(){
        String json = "";
        return  json;
    }

}
