package com.boxin.base.dao;

import java.util.List;

import com.boxin.base.daogen.ManageRoleMapperGen;
import com.boxin.base.model.ManageRole;
import org.apache.ibatis.annotations.Param;

public interface ManageRoleMapper extends ManageRoleMapperGen {

    ManageRole findByCode(String code);
    
    List<ManageRole> findRolesByUserName(String userName) ;

    List<ManageRole> findAllRoles();
    
    List<ManageRole> getAllRoles(@Param("page")int page, @Param("rows")int rows);

    List<ManageRole> findEnableRoles();
	
	


}