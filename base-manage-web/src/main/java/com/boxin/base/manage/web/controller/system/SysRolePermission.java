package com.boxin.base.manage.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boxin.base.service.manage.user.RolePermissionService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.realm.service.ServiceRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boxin.base.common.util.JsonUtil;
import com.boxin.base.model.ManagePermission;
import com.boxin.base.service.manage.user.RoleService;

@Controller
public class SysRolePermission {
	Log logger = LogFactory.getLog(SysRolePermission.class);
	@Autowired
	public RoleService roleService;
	@Autowired
	public RolePermissionService rolePermissionService;
	@Autowired
	public ServiceRealm serviceRealm;

	/**
	 * 权限更新
	 * @return
	 */
	@RequestMapping(value = "/sys/rolepurviewSave", method = RequestMethod.POST)
	public @ResponseBody String rolepurviewSave(HttpServletRequest request,
			HttpServletResponse response) {
		String arr = request.getParameter("arr");
		String code = request.getParameter("code");
		try {
			rolePermissionService.updatePermission(code,arr);
			serviceRealm.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
			return "1";
		} catch (Exception e) {
			return "0";
		}

	}

	/**
	 * 获取角色的权限
	 */
	@RequestMapping(value = "/sys/rolePermissionMenu", method = RequestMethod.POST)
	public @ResponseBody String rolePermissionMenu(HttpServletRequest request,
			HttpServletResponse response) {
		String code = request.getParameter("code");
		List<ManagePermission> mPermissionList;
		try {
			mPermissionList = rolePermissionService
					.findPermissionByCode(code);
		} catch (Exception e) {
			return null;
		}
		String json = JsonUtil.list2Json(mPermissionList);
		json = json.replace("service:", "");
		json = json.replace(".list", "");
		json = json.replace(".", "/");
		json = json.replace("/html", ".html");
		json = json.replace("name", "text");

		return json;

	}

	/**
	 * 获取所有菜单
	 */
	@RequestMapping(value = "/sys/getAllMenuButton", method = RequestMethod.POST)
	public @ResponseBody String getAllMenu()  {
		List<ManagePermission> mPermissionList;
		try {
			mPermissionList = rolePermissionService
					.selectAllMenuButton();
		} catch (Exception e) {
			 return null;
		}
		String menu = JsonUtil.list2Json(mPermissionList);
		menu = menu.replace("service:", "");
		menu = menu.replace(".list", "");
		menu = menu.replace(".", "/");
		menu = menu.replace("/html", ".html");
		menu = menu.replace("name", "text");
		return menu;
	}

}
