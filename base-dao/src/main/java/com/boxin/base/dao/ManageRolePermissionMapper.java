package com.boxin.base.dao;

import java.util.List;

import com.boxin.base.model.ManagePermission;
import com.boxin.base.model.ManageRolePermission;
import com.boxin.base.daogen.ManageRolePermissionMapperGen;

public interface ManageRolePermissionMapper extends ManageRolePermissionMapperGen {

	List<ManagePermission> findPermissionByCode(String code);

	int deleteByCode(String code);
	
	int insert(ManageRolePermission rolePermission);

	List<ManagePermission> selectAllMenuButton();

}