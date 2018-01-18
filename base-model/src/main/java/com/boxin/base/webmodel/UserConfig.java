package com.boxin.base.webmodel;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于记录用户Session信息的bean
 * Created by zy on 2015/4/30.
 */
public class UserConfig implements Serializable{

    //用户未登陆
    public final static int USER_STATUS_UNLOGIN = 0;

    //用户已登陆
    public final static int USER_STATUS_LOGINED = 1;

    //用户已锁定
    public final static int USER_STATUS_LOCKED = 2;

    /**
     *  用户正常状态
     */
    public final static int USER_STATUS_NORMAL = 1;

    /**
     * 用户已删除
     */
    public final static int USER_STATUS_DROPED = 3;

    private int status = USER_STATUS_UNLOGIN;   //用户状态  0未登陆，1已登陆，2已锁定
    private int loginError = 0;    //登陆错误次数
    private  Map<String,Object> userInfo = new HashMap<String,Object>();  //保存用户信息使用

    public static UserConfig newInstance(){
        return new UserConfig();
    }

    public int getLoginError() {
        return loginError;
    }

    public void setLoginError(int loginError) {
        this.loginError = loginError;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Map<String, Object> userInfo) {
        this.userInfo = userInfo;
    }

    public void addUserInfo(String key, Object value) {
        if(null == this.userInfo){
            this.userInfo = new HashMap<String,Object>();
        }
        if(null != this.userInfo){
            this.userInfo.put(key, value);
        }
    }
    public void addUserInfo(Map<String,Object> userInfo) {
        this.userInfo = userInfo;
    }
}
