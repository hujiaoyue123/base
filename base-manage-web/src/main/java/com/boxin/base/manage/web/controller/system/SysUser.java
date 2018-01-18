package com.boxin.base.manage.web.controller.system;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;

import com.boxin.base.common.util.StringUtil;
import com.boxin.base.common.util.WebUtil;
import com.boxin.base.model.ManageUser;
import com.boxin.base.service.manage.user.UserService;
import com.boxin.base.webmodel.GridData;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boxin.base.common.util.JsonUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 此类为用户设置操作类
 * Created by zy on 2015/4/27.
 */
@Controller
public class SysUser {
	@Autowired
	UserService userService;
	Log logger = LogFactory.getLog(SysUser.class);

	/**
	 * 查询所有用户
	 * @return
	 */
	@RequestMapping(value="/sys/findAllUsers",method = RequestMethod.GET)
	public void findAllUser (HttpServletRequest request,HttpServletResponse response){
		GridData gridData = GridData.newInstance();
		String userName = request.getParameter("user_name").trim();
		String realName = request.getParameter("real_name").trim();
		try {
			userName = URLDecoder.decode(userName, "utf-8");
			realName = URLDecoder.decode(realName, "utf-8");
		} catch (UnsupportedEncodingException e1) {
			userName = "";
			realName = "";
		}
		String roleId = request.getParameter("role_id");
		String spage = request.getParameter("page");
		String slimitSize = request.getParameter("rows");

		int page = Integer.parseInt((spage == null || spage == "") ? "1":spage);
		int limitSize = Integer.parseInt((slimitSize == null || slimitSize == "0") ? "10":slimitSize);

		try {
			Map<String,Object> map = userService.findAllUsers(userName, realName, roleId, page, limitSize);
			int total = Integer.parseInt(map.get("total").toString());
			List<ManageUser> manageUserList = (List<ManageUser>)map.get("manageUser");
			gridData.setAsSuccess();
			gridData.setTotalCount(total);
			gridData.addMeta("rows", manageUserList);
		} catch (Exception e) {
			gridData.setAsFailure();
		}
		WebUtil.write(response, JsonUtil.obj2JsonObj(gridData));
	}

	/**
	 * 插入用户
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/sys/insertUser",method = RequestMethod.POST)
	public @ResponseBody String insertUser(HttpServletRequest request){
		String name = request.getParameter("name").trim();
		String realName = request.getParameter("realName").trim();
		String password = request.getParameter("password").trim();
		String stype = request.getParameter("type");
		String phone = request.getParameter("phone").trim();
		String email = request.getParameter("email").trim();
		String sstatus = request.getParameter("status");
		String ids = request.getParameter("rid");
		String[] roleIds = null;

		Map<String,Object> resultMap = new HashMap<String, Object>();
		ManageUser manageUser = new ManageUser();
		//数据校验
		if(StringUtil.isBlank(name,realName,password)){
			resultMap.put("message","用户名、真实名、密码不能为空");
			resultMap.put("state","fail");
			return JsonUtil.map2Json(resultMap);
		}

		int type = Integer.parseInt(stype);
		if(type <0){
			resultMap.put("message","传入类型参数错误");
			resultMap.put("state","fail");
			return JsonUtil.map2Json(resultMap);
		}
		if(!StringUtil.isBlank(phone) && !StringUtil.isPhone(phone)){
			resultMap.put("message","输入的手机号错误");
			resultMap.put("state","fail");
			return JsonUtil.map2Json(resultMap);
		}
		if(!StringUtil.isBlank(email) && !StringUtil.isEmail(email)){
			resultMap.put("message","输入的邮箱错误");
			resultMap.put("state","fail");
			return JsonUtil.map2Json(resultMap);
		}
		int status = Integer.parseInt(sstatus);
		if(status!=0 && status!= 1){
			resultMap.put("message","开关参数设置错误");
			resultMap.put("state","fail");
			return JsonUtil.map2Json(resultMap);
		}
		if(!StringUtil.isBlank(ids)){
			roleIds = ids.split(",");
		}
		//密码加密
		password = new SimpleHash("SHA-256",password, ByteSource.Util.bytes(name),1024).toHex();

		manageUser.setName(name);
		manageUser.setRealName(realName);
		manageUser.setPassword(password);
		manageUser.setPhone(phone);
		manageUser.setEmail(email);
		manageUser.setType(type);
		manageUser.setStatus(status);
		manageUser.setCreateTime(new Date());

		boolean  result = false;
		try {
			//result = userService.insertUserRole(manageUser,roleIds,null);
		} catch (Exception e) {
			resultMap.put("message","操作数据库失败");
			resultMap.put("state", "fail");
			return JsonUtil.map2Json(resultMap);
		}
		if(result){
			resultMap.put("state","success");
		}else{
			resultMap.put("message","插入用户失败");
			resultMap.put("state","fail");
		}
		return JsonUtil.map2Json(resultMap);
	}
	
	
	/**
     * 密码修改
     */
    @RequestMapping(value="/sys/modifyPass",method = RequestMethod.POST)
    public @ResponseBody boolean modifyPass(HttpServletRequest request){
    	String password = request.getParameter("password").trim();
    	String username = request.getParameter("username").trim();
    	String shapassword = new SimpleHash("SHA-256",password, username,1024).toHex();
    	boolean b;
		try {
			b = userService.updatePwd(username, shapassword);
		} catch (Exception e) {
			b = false;
			logger.error(e.getMessage(),e);
		}
        return b;
    }
    

	/**
	 * 查询指定用户对应角色
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/sys/findRolesByUserId",method = RequestMethod.POST)
	public @ResponseBody String findRolesByUserId(HttpServletRequest request){
		String userId = request.getParameter("userId");
		Map<String,Object> resultMap = new HashMap<String, Object>();

		int uid = Integer.parseInt(userId);
		if(uid <=0){
			return null;
		}
		List result = null;
		try {
			result = userService.findRolesByUserId(uid);
		} catch (Exception e) {
			return null;
		}
		return JsonUtil.list2Json(result);
	}

	/**
	 * 更新用户信息
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/sys/updateUser",method = RequestMethod.POST)
	public @ResponseBody String updateUser(HttpServletRequest request){
		String uid = request.getParameter("uid").trim();
		String name = request.getParameter("name").trim();
		String realName = request.getParameter("realName").trim();
		String stype = request.getParameter("type");
		String phone = request.getParameter("phone").trim();
		String email = request.getParameter("email").trim();
		String sstatus = request.getParameter("status");
		String ids = request.getParameter("rid");
		String[] roleIds = null;

		Map<String,Object> resultMap = new HashMap<String, Object>();
		ManageUser manageUser = new ManageUser();

		//数据校验
		if(StringUtil.isBlank(name,realName)){
			resultMap.put("message","用户名、真实名不能为空");
			resultMap.put("state","fail");
			return JsonUtil.map2Json(resultMap);
		}

		int type = Integer.parseInt(stype);
		int id = Integer.parseInt(uid);
		if(type <0 || id < 0){
			resultMap.put("message","传入参数错误");
			resultMap.put("state","fail");
			return JsonUtil.map2Json(resultMap);
		}
		if(!StringUtil.isBlank(phone) && !StringUtil.isPhone(phone)){
			resultMap.put("message","输入的手机号错误");
			resultMap.put("state","fail");
			return JsonUtil.map2Json(resultMap);
		}
		if(!StringUtil.isBlank(email) && !StringUtil.isEmail(email)){
			resultMap.put("message","输入的邮箱错误");
			resultMap.put("state","fail");
			return JsonUtil.map2Json(resultMap);
		}
		int status = Integer.parseInt(sstatus);
		if(status!=0 && status!= 1){
			resultMap.put("message","开关参数设置错误");
			resultMap.put("state","fail");
			return JsonUtil.map2Json(resultMap);
		}
		if(!StringUtil.isBlank(ids)){
			roleIds = ids.split(",");
		}

		manageUser.setId(id);
		manageUser.setName(name);
		manageUser.setRealName(realName);
		manageUser.setPhone(phone);
		manageUser.setEmail(email);
		manageUser.setType(type);
		manageUser.setStatus(status);
		manageUser.setModifyTime(new Date());


		boolean result = false;
		try {
			//result = userService.updateUserRole(manageUser,roleIds,null,stype);
		} catch (Exception e) {
			resultMap.put("message","操作数据库失败");
			resultMap.put("state", "fail");
			return JsonUtil.map2Json(resultMap);
		}
		if(result){
			resultMap.put("state","success");
		}else{
			resultMap.put("message","更新用户失败");
			resultMap.put("state","fail");
		}
		return JsonUtil.map2Json(resultMap);
	}

	/**
	 * 删除用户
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/sys/deleteUserById",method = RequestMethod.POST)
	public @ResponseBody String deleteUserById(HttpServletRequest request){
		String uid = request.getParameter("userId");
		Map<String,Object> resultMap = new HashMap<String, Object>();

		int id = Integer.parseInt(uid);
		if(id<0){
			resultMap.put("message","参数错误");
			resultMap.put("state","fail");
			return JsonUtil.map2Json(resultMap);
		}

		boolean result = false;
		try {
			result = userService.deleteUserById(id);
		} catch (Exception e) {
			resultMap.put("message","操作数据库失败");
			resultMap.put("state", "fail");
			return JsonUtil.map2Json(resultMap);
		}
		if(result){
			resultMap.put("state","success");
		}else{
			resultMap.put("message","删除用户失败");
			resultMap.put("state","fail");
		}
		return JsonUtil.map2Json(resultMap);
	}
	
	@RequestMapping(value="/sys/validateUser",method = RequestMethod.POST)
	public @ResponseBody String validateUser(HttpServletRequest request){
		String name = request.getParameter("name");
		try {
			ManageUser user  = userService.findUserByName(name);
			if(null == user )
				return "success";
			else
				return "faile";
		} catch (Exception e) {
			return "err";
		}
		
	}
	

}
