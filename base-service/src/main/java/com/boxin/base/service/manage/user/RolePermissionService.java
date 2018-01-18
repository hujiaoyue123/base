package com.boxin.base.service.manage.user;

import java.util.List;
import com.boxin.base.model.ManagePermission;
import com.boxin.base.model.ManageRolePermission;

/**
 * @author aaron
 * 
 */
public interface RolePermissionService {
	
	
	/**
	 *  删除角色权限
	 */
	public boolean deleteByCode(String code) throws Exception;
	
	/**
	 * 添加角色权限
	 */
	public boolean insert(ManageRolePermission rolePermission) throws Exception;
	
	/**
	 * 根据code获取角色权限菜单
	 */
	public List<ManagePermission> findPermissionByCode(String code) throws Exception;
	
	/**
	 * 获取所有的菜单按钮
	 */
	public List<ManagePermission> selectAllMenuButton() throws Exception;

	/**
	 * 更新角色权限
	 * @param code
	 * @param arr
	 */
	public boolean updatePermission(String code, String arr) throws Exception;
}