package com.boxin.base.manage.web.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 工具类，存储鉴权推送及播放URL
 * Created by zy on 2017/7/12.
 */
public class PushPlayAuthURL {

    private static final String PUSH_URL = "push_url";
    private static final String RTMP_URL = "rtmp_url";
    private static final String FLV_URL = "flv_url";
    private static final String M3U8_URL = "m3u8_url";

    private Map<String,String> authMap;

    public  PushPlayAuthURL(){
        authMap = new HashMap<String,String>();
    }

    public void setPushUrl(String url){
         authMap.put(PUSH_URL,url);
    }

    public String getPushUrl(){
         return authMap.get(PUSH_URL);
    }

    public void setRtmpUrl(String url){
        authMap.put(RTMP_URL,url);
    }

    public String getRtmpUrl(){
        return authMap.get(RTMP_URL);
    }

    public void setFlvUrl(String url){
        authMap.put(FLV_URL,url);
    }

    public String getFlvUrl(){
        return authMap.get(FLV_URL);
    }

    public void setM3u8Url(String url){
        authMap.put(M3U8_URL,url);
    }

    public String getM3u8Url(){
        return authMap.get(M3U8_URL);
    }
}
