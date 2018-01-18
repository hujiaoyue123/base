package com.boxin.base.service.manage.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.boxin.base.dao.ManageUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boxin.base.model.ManageUser;
import com.boxin.base.service.manage.user.UserService;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import org.springframework.transaction.annotation.Transactional;

/**
 * 后台用户服务实现类
 *
 * @author zouyu
 * @date 2015-4-16
 */
@Service
public class UserServiceImpl implements UserService {

    private final static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    ManageUserMapper manageUserMapper;
    @Override
    public boolean insert(ManageUser user) throws Exception {
        try {
            Preconditions.checkNotNull(user, "user mustn't be null");
            Preconditions.checkNotNull(user.getName(), "userName mustn't be null");
            return manageUserMapper.insert(user) == 1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }

    @Override
    public boolean update(ManageUser user) throws Exception {
        try {
            Preconditions.checkNotNull(user, "user mustn't be null");
            Preconditions.checkNotNull(user.getId(), "userId mustn't be null");
            return manageUserMapper.updateByPrimaryKeySelective(user) == 1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }

    @Override
    public boolean updatePwd(String userName, String oldP, String newP) throws Exception {
        try {
            Preconditions.checkArgument(!Strings.isNullOrEmpty(userName), "userName mustn't be empty");
            Preconditions.checkArgument(!Strings.isNullOrEmpty(oldP), "oldP mustn't be empty");
            Preconditions.checkArgument(!Strings.isNullOrEmpty(newP), "newP mustn't be empty");
            Preconditions.checkArgument(!oldP.equals(newP), "newP mustn't be equal to old");
            return manageUserMapper.updatePwd(userName, oldP, newP) == 1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }

    @Override
    public ManageUser findUserByName(String name) throws Exception {
        try {
            return manageUserMapper.findByName(name);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }

	@Override
	public Map<String,Object> findAllUsers(String userName,String realName,String roleId,int page,int limitSize) throws Exception {
        try {
            int total = manageUserMapper.findAllUserSize(userName,realName,roleId);
            List<ManageUser> manageUserList =  manageUserMapper.findAllUsers(userName, realName, roleId, (page - 1) * limitSize, limitSize);
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("total",total);
            map.put("manageUser",manageUserList);
            return map;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }

	@Override
	public boolean updatePwd(String userName, String newP) throws Exception {
		try {
            Preconditions.checkArgument(!Strings.isNullOrEmpty(userName), "userName mustn't be empty");
            Preconditions.checkArgument(!Strings.isNullOrEmpty(newP), "newP mustn't be empty");
            return manageUserMapper.updatePassWord(userName,newP) == 1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
	}

    @Override
    @Transactional
    public boolean insertUserRole(ManageUser user,String[] roleIds) throws Exception {
        boolean b = false;
        try {
            Preconditions.checkNotNull(user, "user mustn't be null");
            //插入用户
            b =  insert(user);
            if(roleIds == null ){
                return b;
            }
            //查询用户
            ManageUser manageUser =  manageUserMapper.findByName(user.getName());

            for(String sid :roleIds){
                int id = Integer.parseInt(sid);
                if(id >=0){
                    //插入用户角色关联数据
                    b = (b && manageUserMapper.insertUserRoleRelevance(manageUser.getId(),id)==1);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }

        return b;
    }

    @Override
    public List findRolesByUserId(int uid) throws Exception {
        try {
            Preconditions.checkArgument(uid > 0, "uid is less than zero");
            return manageUserMapper.findRolesByUserId(uid);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }

    @Override
    @Transactional
    public boolean updateUserRole(ManageUser user,String[] roleIds,String stype) throws Exception {
        try {
            Preconditions.checkNotNull(user, "user mustn't be null");
            //更新用户
            update(user);
            //删除原来用户角色关联
            manageUserMapper.deleteUserRoleRelevance(user.getId());
            if(roleIds == null){
                return true;
            }
            for(String sid :roleIds){
                int id = Integer.parseInt(sid);
                if(id >=0){
                    //插入用户角色关联数据
                    manageUserMapper.insertUserRoleRelevance(user.getId(),id);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
        return true;
    }

    @Override
    public boolean deleteUserById(int id) throws Exception {
        try {
            Preconditions.checkArgument(id > 0, "id must be bigger than zero ");
            //删除原来用户角色关联关系
            manageUserMapper.deleteUserRoleRelevance(id);
            
            //删除用户
            return manageUserMapper.removeUser(id) == 1;
            //删除用户
//            ManageUser manageUser = new ManageUser();
//            manageUser.setId(id);
//            manageUser.setStatus(0);
//            return manageUserMapper.updateByPrimaryKeySelective(manageUser) == 1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new Exception(e);
        }
    }

    @Override
	public void quartzTest(ManageUser user) {
		manageUserMapper.quartzTest(user);
		
	}
}
