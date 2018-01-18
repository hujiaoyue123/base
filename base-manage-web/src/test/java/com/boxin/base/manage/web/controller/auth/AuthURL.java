package com.boxin.base.manage.web.controller.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zy on 2017/7/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "classpath:spring/*.xml")
public class AuthURL {

    public String md5sum(String src) throws NoSuchAlgorithmException {
        byte [] buf = src.getBytes();
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(buf);
        byte [] tmp = md5.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b:tmp) {
            sb.append(Integer.toHexString(b&0xff));
        }
        System.out.println(sb);
        return sb.toString().trim();
    }


    @Test
    public  void testFun() throws NoSuchAlgorithmException {
        System.out.println(md5sum("zy"));
    }



}
