package com.boxin.base.webmodel;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zy on 2015/4/29.
 */
public class ResultData {

    private boolean success = false; // 响应状态,布尔值, false为失败,true为成功,只准出现这两个值,不是字符串
    private String errorcode = "0000"; // 错误码,由接口自己定义, success 为false时生效
    private String message = ""; // 可为空,由接口设置
    private Map<String,Object> meta = new HashMap<String,Object>();   // 元数据,Map类型.额外信息存储
    private Object data = null;  //响应结果数据,对象/array类型,对应后端的 Bean/List

    public static ResultData newInstance(){
        return new ResultData();
    }

    public boolean isSuccess() {
        return success;
    }
    /**
     * 设置为成功状态
     */
    public void setAsSuccess() {
        this.success = true;
    }

    public void setAsFailure() {
        this.success = false;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String geterrorcode() {
        return errorcode;
    }

    public void seterrorcode(String errorCode) {
        this.errorcode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String,Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 添加单个Meta内的数据
     * @param key
     * @param value
     */
    public void addMeta(String key, Object value) {
        if(null == this.meta){
            this.meta = new HashMap<String,Object>();
        }
        if(null != this.meta){
            this.meta.put(key, value);
        }
    }

    /**
     * 获取单个Meta的数据
     * @param key
     * @return
     */
    public Object getMetaValue(String key) {
        Object res = null;
        if(null == this.meta){
            this.meta = new HashMap<String,Object>();
        }
        if(null != this.meta){
            res = this.meta.get(key);
        }
        return res;
    }
}
