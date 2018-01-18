package com.boxin.base.common.util;

import javax.servlet.http.HttpServletRequest;
import java.net.Inet4Address;

/**
 * IP工具类
 * Created by zy on 2015/5/2.
 */
public class IpUtil {

    /**
     * 获取用户IP
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("PRoxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip.equals("0:0:0:0:0:0:0:1")) {
            ip = "127.0.0.1";
        }
        if (ip.split(",").length > 1) {
            ip = ip.split(",")[0];
        }
        return ip;
    }

    /**
     * 将长整型IP转换成字符串IP
     * @param add
     * @return
     */
    public static String inet_ntoa(long add) {
        return ((add & 0xff000000) >> 24) + "." + ((add & 0xff0000) >> 16)
                + "." + ((add & 0xff00) >> 8) + "." + ((add & 0xff));
    }

    /**
     * 将Inet4Address类型IP转换成长整型
     * @param add
     * @return
     */
    public static long inet_aton(Inet4Address add) {
        byte[] bytes = add.getAddress();
        long result = 0;
        for (byte b : bytes) {
            if ((b & 0x80L) != 0) {
                result += 256L + b;
            } else {
                result += b;
            }
            result <<= 8;
        }
        result >>= 8;
        return result;
    }

    /**
     * 将数字类型IP转换成长整型
     * @param add
     * @return
     */
    public static long inet_aton(String add) {
        long result = 0;
        long section = 0;
        int times = 1;
        int dots = 0;
        for (int i = add.length() - 1; i >= 0; --i) {
            if (add.charAt(i) == '.') {
                times = 1;
                section <<= dots * 8;
                result += section;
                section = 0;
                ++dots;
            } else {
                section += (add.charAt(i) - '0') * times;
                times *= 10;
            }
        }
        section <<= dots * 8;
        result += section;
        return result;
    }
}
