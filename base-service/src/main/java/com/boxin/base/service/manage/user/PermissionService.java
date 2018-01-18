package com.boxin.base.service.manage.user;

import com.boxin.base.model.ManagePermission;

import java.util.List;

/**
 * 后台权限服务接口类
 * @author zouyu
 * @date 2015-4-16
 */
public interface PermissionService {

	/**
	 * 根据用户ID查询权限
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	List<String> findPermissionByUserId(int userId) throws Exception;

	/**
	 * 查询所用的菜单
	 * @return
	 * @throws Exception
	 */
	List<ManagePermission> selectAllMenu() throws Exception;

	/**
	 * 通过根结点ID查询菜单树
	 * @param id
	 * @return
	 * @throws Exception
	 */
	List<ManagePermission> selectMenuById(Long id) throws Exception;

	/**
	 * 插入菜单或功能
	 * @param managePermission
	 * @return
	 * @throws Exception
	 */
	boolean insert(ManagePermission managePermission) throws Exception;

	/**
	 * 通过菜单ID删除菜单
	 * @param id
	 * @return
	 */
	boolean deleteMenuById(Long id) throws Exception;

	/**
	 * 判断指定菜单（id）下是否有子菜单
	 * @param id
	 * @return
	 */
	boolean hasChildNode(Long id) throws Exception;

	/**
	 * 更新菜单或功能信息
	 * @param managePermission
	 * @return
	 */
	boolean update(ManagePermission managePermission) throws Exception;

	/**
	 * 根据页面ID（父id）查询页面功能
	 * @param pid
	 * @return
	 * @throws Exception
	 */
	List<ManagePermission> findFunctionByPid(long pid) throws Exception ;

}
