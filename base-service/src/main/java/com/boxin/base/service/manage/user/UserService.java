package com.boxin.base.service.manage.user;

import java.util.List;
import java.util.Map;

import com.boxin.base.model.ManageUser;


/**
 * 后台用户服务接口类
 * @author zouyu
 * @date 2015-4-16
 */
public interface UserService {

	/**
	 * 新增
	 *
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean insert(ManageUser user) throws Exception;

	/**
	 * 修改，注：不能修改密码
	 *
	 * @param user
	 * @return
	 * @throws Exception
	 */
	boolean update(ManageUser user) throws Exception;

	/**
	 * 修改密码
	 *
	 * @param userName
	 * @param oldP
	 * @param newP
	 * @return
	 * @throws Exception
	 */
	boolean updatePwd(String userName, String oldP, String newP) throws Exception;

	/**
	 * 修改密码
	 * @param userName
	 * @param newP
	 * @return
	 * @throws Exception
	 */
	boolean updatePwd(String userName, String newP) throws Exception;
	/**
	 * 根据用户名查询用户
	 *
	 * @param name
	 * @return
	 * @throws Exception
	 */
	ManageUser findUserByName(String name) throws Exception;
	
	/**
	 * 查询所有用户
	 */
	Map<String,Object> findAllUsers(String userName,String realName,String roleId,int page,int limitSize) throws Exception;

	/**
	 * 插入用户及角色
	 * @param user
	 * @param roleIds
	 * @return
	 */
	boolean insertUserRole(ManageUser user,String[] roleIds) throws Exception;

	/**
	 * 查询用户指定的角色
	 * @param uid
	 * @return
	 */
	List findRolesByUserId(int uid) throws Exception;


	/**
	 * 更新用户及角色
	 * @param user
	 * @param roleIds
	 * @return
	 */
	boolean updateUserRole(ManageUser user,String[] roleIds,String stype) throws Exception;

	boolean deleteUserById(int id) throws Exception;

	void quartzTest(ManageUser user);

}