package com.boxin.base.manage.web.controller.util;

import com.boxin.base.manage.web.util.AliyunPushServiceUtil;
import com.boxin.base.manage.web.util.PushPlayAuthURL;
import org.junit.Test;

/**
 * Created by zy on 2017/7/12.
 */
public class AliyunPushServiceUtilTest {

    @Test
    public void test(){
        PushPlayAuthURL playAuthURL = new AliyunPushServiceUtil().getAuthPushPlayURL("cctvjy", "live20170712", 60 * 60 * 1);

        System.out.println(playAuthURL.getPushUrl());
        System.out.println(playAuthURL.getRtmpUrl());
        System.out.println(playAuthURL.getFlvUrl());
        System.out.println(playAuthURL.getM3u8Url());

        //rtmp://video-center.alivecdn.com/cctvjy/live20170712?vhost=baba.ewcj.com.cn&auth_key=1499846327-0-0-7a94a9f71edbefddb33054a6fe47125f
        //rtmp://video-center.alivecdn.com/cctvjy/live20170712?vhost=baba.ewcj.com.cn&auth_key=1499846327-0-0-7a94a9f71edbefddb33054a6fe47125f
    }
}
