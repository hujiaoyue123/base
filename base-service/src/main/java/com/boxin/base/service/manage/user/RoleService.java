package com.boxin.base.service.manage.user;

import java.util.List;

import com.boxin.base.model.ManageRole;

/**
 * 后台角色服务接口类
 * @author zouyu
 * @date  2015-4-16
 */
public interface RoleService {

	/**
	 * 新增
	 *
	 * @param role
	 * @return
	 */
	int insert(ManageRole role) throws Exception;

	/**
	 * 更新
	 *
	 * @param role
	 * @return
	 * @throws Exception
	 */
	boolean update(ManageRole role) throws Exception;

	boolean updateByPrimaryKeySelective(ManageRole role) throws Exception;

	/**
	 * 根据code查询角色
	 *
	 * @param code
	 * @return
	 * @throws Exception
	 */
	ManageRole findByCode(String code) throws Exception;

	/**
	 * 根据用户名查找角色
	 *
	 * @param userName
	 * @return
	 */
	List<ManageRole> findRolesByUserName(String userName) throws Exception;

	/**
	 * 根据用户id查询用户角色名称
	 *
	 * @param userName
	 * @return
	 */
	List<String> findRoleNamesByUserName(String userName) throws Exception;

	/**
	 * 查询所用角色信息
	 * @return
	 * @throws Exception
	 */
	List<ManageRole> findAllRoles() throws Exception;
	
	/**
	 * 查询所用角色信息
	 * @return
	 * @throws Exception
	 */
	List<ManageRole> findAllRoles(int pages, int rows) throws Exception;

	/**
	 * 查询所用可用的角色
	 * @return
	 */
	List<ManageRole> findEnableRoles() throws Exception;


}
