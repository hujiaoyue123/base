package com.boxin.base.dao;

import com.boxin.base.daogen.ManagePermissionMapperGen;
import com.boxin.base.model.ManagePermission;

import java.util.List;

public interface ManagePermissionMapper extends ManagePermissionMapperGen {

    int hasChildNode(Long id);

    int deleteMenuById(Long id);

    List<ManagePermission> selectAllMenu();

    List<ManagePermission> selectMenuById(Long id);

    //int updateMenu(ManagePermission managePermission);

    List<ManagePermission>  findPermissionByUserId(int userId);

    List<ManagePermission> findFunctionByPid(long pid);

    List<ManagePermission> findAllMenu();
}