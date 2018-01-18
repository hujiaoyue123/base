package com.boxin.base.manage.web.util;

import com.boxin.base.common.util.StringUtil;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zy on 2017/7/12.
 */
public class AliyunPushServiceUtil {

    //鉴权AUTH_KEY
    private final static String AUTH_KEY = "baba01";

    //阿里云视频直播推送基础地址
    //完整路径：rtmp://video-center.alivecdn.com/APPNAME/STREAMNAME?vhost=baba.ewcj.com.cn&auth_key=TIMESTAMP-0-0-HASHVALUE
    private final static String BASE_PUSH_URL = "rtmp://video-center.alivecdn.com";
    private String BASE_PUSH_URL_SUFFIX= "/APPNAME/STREAMNAME?vhost=baba.ewcj.com.cn";
    private String BASE_PUSH_URL_AUTH_KEY = "&auth_key=TIMESTAMP-0-0-HASHVALUE";
    private String BASE_AUTH_MD5 = "/APPNAME/STREAMNAME?vhost=baba.ewcj.com.cn-TIMESTAMP-0-0-HASHVALUE";

    //阿里云视频直播播放基础地址（rtmp、flv、m3u8格式）
    private String BASE_PLAYER_RTMP_URL = "rtmp://baba.ewcj.com.cn/APPNAME/STREAMNAME";
    private String BASE_PLAYER_FLV_URL = "http://baba.ewcj.com.cn/APPNAME/STREAMNAME.flv";
    private String BASE_PLAYER_M3U8_URL = "http://baba.ewcj.com.cn/APPNAME/STREAMNAME.m3u8";

    /**
     * md5加密
     * @param src
     * @return
     */
    public static String md5sum(String src){
        byte [] buf = src.getBytes();
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return  "";
        }
        md5.update(buf);
        byte [] tmp = md5.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b:tmp) {
            if(Integer.toHexString(b&0xff).length() == 1){
                sb.append("0").append(Integer.toHexString(b&0xff));
            }else{
                sb.append(Integer.toHexString(b & 0xff));
            }
        }
        System.out.println(sb);
        return sb.toString().trim();

    }

    /**
     * 生成推播URL
     *
     * @param appName
     * @param streamName
     * @param time
     * @return
     */
    public PushPlayAuthURL getAuthPushPlayURL(String appName,String streamName,Integer time){
        String authPushURL = "";
        PushPlayAuthURL authURL = new PushPlayAuthURL();

        Date date = new Date();
        Long nowTime = date.getTime()/1000;
        System.out.println(nowTime);
        Long validTime = nowTime + time;
        validTime = 1499917373L;

        //生成鉴权URL
        /**
         1、 通过 req_auth 请求对象:
         http:// cdn.example.com/video/standard/1K.html
         2、 密钥设为：aliyuncdnexp1234 (由用户自行设置)
         3、 鉴权配置文件失效日期为：2015年10月10日00:00:00,计算出来的秒数为1444435200
         4、 服务器会构造一个用于计算Hashvalue的签名字符串：
         /video/standard/1K.html-1444435200-0-0-aliyuncdnexp1234"
         5、服务器会根据该签名字符串计算HashValue
         HashValue = md5sum("/video/standard/1K.html-1444435200-0-0-aliyuncdnexp1234") = 80cd3862d699b7118eed99103f2a3a4f
         6、请求时url为
         http://cdn.example.com/video/standard/1K.html?auth_key=1444435200-0-0-80cd3862d699b7118eed99103f2a3a4f
         计算出来的HashValue与用户请求中带的 md5hash = 80cd3862d699b7118eed99103f2a3a4f 值一致，于是鉴权通过。
         */
        BASE_PUSH_URL_SUFFIX = BASE_PUSH_URL_SUFFIX.replace("APPNAME",appName).replace("STREAMNAME",streamName);
        BASE_PUSH_URL_AUTH_KEY = BASE_PUSH_URL_AUTH_KEY.replace("TIMESTAMP",validTime.toString()).replace("HASHVALUE",AUTH_KEY);
        String urlSuffix  = "/"+appName+"/"+streamName+"-"+validTime+"-0-0-"+AUTH_KEY;

        String hashValue = md5sum(urlSuffix);
        if(!StringUtil.isEmpty(hashValue)){
            BASE_PUSH_URL_AUTH_KEY = BASE_PUSH_URL_AUTH_KEY.replace(AUTH_KEY,hashValue);
            authPushURL = BASE_PUSH_URL + BASE_PUSH_URL_SUFFIX + BASE_PUSH_URL_AUTH_KEY;
            authURL.setPushUrl(authPushURL);

            String flvFileName = "/"+appName+"/"+streamName+".flv";
            String flvString = flvFileName +"-"+validTime+"-0-0-"+AUTH_KEY;
            String flvmd5 = md5sum(flvString);
            String flvAuthKey = "?auth_key="+validTime+"-0-0-"+flvmd5;

            String m3u8FileName = "/"+appName+"/"+streamName+".m3u8";
            String m3u8string = m3u8FileName +"-"+validTime+"-0-0-"+AUTH_KEY;
            String m3u8md5 = md5sum(m3u8string);
            String m3u8AuthKey = "?auth_key="+validTime+"-0-0-"+m3u8md5;

            String fileName = "/"+appName+"/"+streamName;
            String sstring = fileName +"-"+validTime+"-0-0-"+AUTH_KEY;
            String md5 = md5sum(sstring);
            String AuthKey = "?auth_key="+validTime+"-0-0-"+md5;


            /**
             * 生成播放路径
             * BASE_PLAYER_RTMP_URL+BASE_PUSH_URL_AUTH_KEY
             */
            String rtmp_url = BASE_PLAYER_RTMP_URL.replace("APPNAME", appName).replace("STREAMNAME", streamName);
            String rtmp = rtmp_url +  AuthKey;

            String flv_url = BASE_PLAYER_FLV_URL.replace("APPNAME", appName).replace("STREAMNAME", streamName);
            String flv = flv_url + flvAuthKey;

            String m3u8_url = BASE_PLAYER_M3U8_URL.replace("APPNAME", appName).replace("STREAMNAME", streamName);
            String m3u8 = m3u8_url +  m3u8AuthKey;

            authURL.setRtmpUrl(rtmp);
            authURL.setFlvUrl(flv);
            authURL.setM3u8Url(m3u8);
        }

        return authURL;
    }

}
