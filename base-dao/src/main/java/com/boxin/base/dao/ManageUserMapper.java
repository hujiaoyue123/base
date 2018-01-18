package com.boxin.base.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.boxin.base.daogen.ManageUserMapperGen;
import com.boxin.base.model.ManageUser;


public interface ManageUserMapper extends ManageUserMapperGen {

	ManageUser findByName(String name);

    List<ManageUser> findAllUsers(@Param("userName")String userName,@Param("realName")String realName,@Param("roleId")String roleId,@Param("page")Integer page,@Param("limitSize")Integer limitSize);

    int findAllUserSize(@Param("userName")String userName,@Param("realName")String realName,@Param("roleId")String roleId);
	 
    int updatePwd(@Param("userName")String userName, @Param("oldPwd")String oldPwd, @Param("newPwd")String newPwd);

    int updatePassWord(@Param("userName")String userName,@Param("newPwd")String newPwd);

    int insertUserRoleRelevance(@Param("uId") Integer uId,@Param("rId") Integer rId);

    List findRolesByUserId(int uid);

    int deleteUserRoleRelevance(int id);
    
    int removeUser(int id);
	
	int quartzTest(ManageUser user);


}