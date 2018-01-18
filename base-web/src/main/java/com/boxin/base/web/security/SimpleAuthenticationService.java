package com.boxin.base.web.security;

//import com.wuyintong.organization.model.User;
//import com.wuyintong.organization.service.PermissionService;
//import com.wuyintong.organization.service.RoleService;
//import com.wuyintong.organization.service.UserService;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.realm.service.AuthenticationService;
import org.apache.shiro.realm.service.SaltedPassword;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zy (zy171450@163.com)
 * @date 2013-12-5
 */
@Component
public class SimpleAuthenticationService implements AuthenticationService {

//    @Autowired
//    UserService userService;
//
//    @Autowired
//    RoleService roleService;
//
//    @Autowired
//    PermissionService permissionService;

    @Override
    public SaltedPassword findSaltedPasswordByUserName(String username) throws Exception {
        SaltedPassword saltedPassword = null;
        try {
            User user = new User(1L,"admin","password");//userService.findUserByName(username);
            if (user == null) {
                throw new Exception("user[" + username + "] doesnt exists.");
            }else{
                saltedPassword = new SaltedPassword(user.getId(), user.getPassword(), user.getName());
            }
        } catch (Exception ex) {
            throw new AccountException("findSaltedPasswordByUserName error:" + ex.getMessage());
        }
        return saltedPassword;
    }

    @Override
    public Set<String> findRoleNamesForUserName(String username) throws Exception {
        List<String> roleNames = null;
        try {
            User user = new User(1L,"admin","password");// userService.findUserByName(username);
            if (user == null)
                throw new Exception("user[" + username + "] doesnt exists.");
            Long userId = user.getId();
            roleNames = Arrays.asList(new String[]{"admin","user"});//roleService.findRoleNamesByUserId(userId);
        } catch (Exception ex) {
            throw new AuthorizationException("findRoleNamesForUserName error:" + ex.getMessage());
        }
        return roleNames == null ? null : new HashSet<String>(roleNames);
    }

    @Override
    public Set<String> findPermissions(String username, Set<String> roleNames) throws Exception {
        List<String> perms = null;
        try {
            User user = new User(1L,"admin","password");// userService.findUserByName(username);
            if (user == null)
                throw new Exception("user[" + username + "] doesnt exists.");
            Long userId = user.getId();
            perms = Arrays.asList(new String[]{"user/add","user/list"});//permissionService.findByUserId(userId,username.split(":")[0],username.split(":")[1]);
        } catch (Exception ex) {
            throw new AuthorizationException("findPermissions error:" + ex.getMessage());
        }
        return perms == null ? null : new HashSet<String>(perms);
    }

}
