package com.boxin.base.service.manage.user.impl;

import java.util.ArrayList;
import java.util.List;

import com.boxin.base.dao.ManageRoleMapper;
import com.boxin.base.model.ManageRole;
import com.boxin.base.service.manage.user.RoleService;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * 后台角色服务实现类
 * @author zouyu
 * @date  2015-4-16
 */
@Service
public class RoleServiceImpl implements RoleService {

	private final static Logger logger = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired
	ManageRoleMapper manageRoleMapper;

	@Override
	public int insert(ManageRole role) throws Exception {
		try {
			Preconditions.checkNotNull(role, "role mustn't be null");
			Preconditions.checkArgument(!Strings.isNullOrEmpty(role.getName()), "roleName mustn't be empty");
			return manageRoleMapper.insert(role);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public boolean update(ManageRole role) throws Exception {
		try {
			Preconditions.checkNotNull(role, "role mustn't be null");
			Preconditions.checkNotNull(role.getId(), "roleId mustn't be null");
			return manageRoleMapper.updateByPrimaryKey(role) == 1;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public ManageRole findByCode(String code) throws Exception {
		try {
			Preconditions.checkArgument(!Strings.isNullOrEmpty(code), "code mustn't be empty");
			return manageRoleMapper.findByCode(code);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public List<ManageRole> findRolesByUserName(String userName) throws Exception {
		try {
			Preconditions.checkArgument(!Strings.isNullOrEmpty(userName), "userName mustn't be empty");
			return manageRoleMapper.findRolesByUserName(userName);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public List<String> findRoleNamesByUserName(String userName) throws Exception {
		List<String> roleNames = new ArrayList<String>();
		try {
			Preconditions.checkArgument(!Strings.isNullOrEmpty(userName), "userName mustn't be empty");
			List<ManageRole> manageRoles = findRolesByUserName(userName);
			if (CollectionUtils.isNotEmpty(manageRoles)) {
				for (ManageRole manageRole : manageRoles) {
					roleNames.add(manageRole.getCode());
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
		return roleNames;
	}

	public List<ManageRole> findAllRoles() throws Exception {
		try {
			return manageRoleMapper.findAllRoles();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	public List<ManageRole> findEnableRoles() throws Exception {
		try {
			return manageRoleMapper.findEnableRoles();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	public boolean updateByPrimaryKeySelective(ManageRole role) throws Exception {
		try {
			return manageRoleMapper.updateByPrimaryKeySelective(role) == 1;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public List<ManageRole> findAllRoles(int page, int rows) throws Exception {
		try {
			return manageRoleMapper.getAllRoles((page-1)*rows,rows);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

}