package com.boxin.base.service.manage.user.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boxin.base.dao.ManageRolePermissionMapper;
import com.boxin.base.model.ManagePermission;
import com.boxin.base.model.ManageRolePermission;
import com.boxin.base.service.manage.user.RolePermissionService;
@Service
public class RolePermissionServiceImpl implements RolePermissionService{
	private final static Logger logger = LoggerFactory.getLogger(RolePermissionServiceImpl.class);
	@Autowired
	public ManageRolePermissionMapper manageRolePermissionMapper;

	@Override
	public boolean insert(ManageRolePermission rolePermission) throws Exception {
		
		try {
			 manageRolePermissionMapper.insert(rolePermission);
			 return Boolean.TRUE;
		} catch (Exception e) {
			 logger.error(e.getMessage(), e);
			 throw new Exception();
		}
		
	}

	@Override
	public boolean deleteByCode(String code) throws Exception {
		try {
			manageRolePermissionMapper.deleteByCode(code);
			return Boolean.TRUE;
		} catch (Exception e) {
			 logger.error(e.getMessage(), e);
			 throw new Exception();
		}
	}

	@Override
	public List<ManagePermission> findPermissionByCode(String code) throws Exception {
		try {
			return manageRolePermissionMapper.findPermissionByCode(code);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public List<ManagePermission> selectAllMenuButton() throws Exception{
		
		try {
			return manageRolePermissionMapper.selectAllMenuButton();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public boolean updatePermission(String code, String arr) throws Exception{
		try {
			String[] arrs = arr.split(",");
			manageRolePermissionMapper.deleteByCode(code);
			for (int i = 0; i < arrs.length && !("").equals(arr.trim()); i++) {
				ManageRolePermission rolePermission = new ManageRolePermission();
				rolePermission.setRoleId(Integer.parseInt(code));
				rolePermission.setPermissionId(Integer.parseInt(arrs[i]));
				manageRolePermissionMapper.insert(rolePermission);
			}
			return Boolean.TRUE;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

}