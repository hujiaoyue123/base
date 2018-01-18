package com.boxin.base.service.manage.user.impl;

import com.boxin.base.dao.ManagePermissionMapper;
import com.boxin.base.model.ManagePermission;
import com.boxin.base.service.manage.user.PermissionService;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

	private final static Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

	@Autowired
	ManagePermissionMapper managePermissionMapper;

	@Override
	public List<String> findPermissionByUserId(int userId) throws Exception {
		List<String> perm = new ArrayList<String>();
		try {
			Preconditions.checkArgument(userId>0, "userId must be bigger than zero ");
			List<ManagePermission>  mPermissions = managePermissionMapper.findPermissionByUserId(userId);
			for(ManagePermission mPermission :mPermissions){
                perm.add(mPermission.getCode());
            }
			return perm;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public List<ManagePermission> selectAllMenu() throws Exception {
		try {
//			return managePermissionMapper.selectAllMenu();
			return managePermissionMapper.findAllMenu();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public List<ManagePermission> selectMenuById(Long id) throws Exception {
		try {
			Preconditions.checkArgument(id>0, "userId must be bigger than zero ");
			return managePermissionMapper.selectMenuById(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public boolean insert(ManagePermission managePermission) throws Exception {
		try {
			Preconditions.checkNotNull(managePermission, "ManagePermission mustn't be null");
			return managePermissionMapper.insert(managePermission) == 1;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public boolean deleteMenuById(Long id) throws Exception {
		try {
			Preconditions.checkArgument(id > 0, "id must be bigger than zero ");
			ManagePermission managePermission = new ManagePermission();
			managePermission.setId(id);
			managePermission.setStatus(0);
			return managePermissionMapper.updateByPrimaryKeySelective(managePermission) == 1;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public boolean hasChildNode(Long id) throws Exception {
		try {
			Preconditions.checkArgument(id > 0, "id must be bigger than zero ");
			return managePermissionMapper.hasChildNode(id) > 0 ;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public boolean update(ManagePermission managePermission) throws Exception {
		try {
			Preconditions.checkNotNull(managePermission, "ManagePermission mustn't be null");
			return managePermissionMapper.updateByPrimaryKey(managePermission) == 1;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

	@Override
	public List<ManagePermission> findFunctionByPid(long pid)throws Exception {
		try {
			Preconditions.checkArgument(pid > 0, "pid must be bigger than zero ");
			return managePermissionMapper.findFunctionByPid(pid);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			throw new Exception(e);
		}
	}

}
