package com.boxin.base.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by zy on 2015/4/30.
 */
public class EncryptUtil {

    private final static String SALT = "!@#$%^&*()";

    /**
     * 对字符串进行加密
     * @param password
     * @return
     */
    public static String password(String password){
        return new SimpleHash("SHA-256",password, SALT,1024).toHex();
    }

    /**
     * 将传入的原文与加密后的密文进行比对
     * @param srcText 密码原文
     * @param destText 密码密文
     * @return
     */
    public static boolean check(String srcText,String destText){
        return passwordCheck(srcText, destText);
    }

    /**
     * 比对密码
     * @param srcText 密码原文
     * @param destText 密码密文
     * @return
     */
    public static boolean passwordCheck(String srcText,String destText){
        if(StringUtil.isEmpty(srcText) || StringUtil.isEmpty(destText)){
            return false;
        }
        String src2 = password(srcText);
        return destText.equals(src2);
    }


    /**
     * 对数字执行 md5 摘要加密
     * @param number
     * @return
     */
    public static String md5(long number) {
        return md5("" + number);
    }
    /**
     * 对文本执行 md5 摘要加密, 此算法与 mysql,JavaScript生成的md5摘要进行过一致性对比.
     * @param plainText
     * @return
     */
    public static String md5(String plainText) {
        if (null == plainText) {
            plainText = "";
        }
        String MD5Str = "";
        try {
            // JDK 6 支持以下6种消息摘要算法，不区分大小写
            // md5,sha(sha-1),md2,sha-256,sha-384,sha-512
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuilder builder = new StringBuilder(32);
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    builder.append("0");
                builder.append(Integer.toHexString(i));
            }
            MD5Str = builder.toString();
            // LogUtil.println("result: " + buf.toString());// 32位的加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return MD5Str;
    }

    /**
     * 对文本执行 SHA-1 摘要加密
     * @param plainText
     * @return
     */
    public static String sha(String plainText) {
        if (null == plainText) {
            plainText = "";
        }
        String MD5Str = "";
        try {
            // JDK 6 支持以下6种消息摘要算法，不区分大小写
            // md5,sha(sha-1),md2,sha-256,sha-384,sha-512
            MessageDigest md = MessageDigest.getInstance("sha");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuilder builder = new StringBuilder();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    builder.append("0");
                builder.append(Integer.toHexString(i));
            }
            MD5Str = builder.toString();
            // LogUtil.println("result: " + buf.toString());// 32位的加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return MD5Str;
    }
    /**
     * 对文本执行 SHA-256 摘要加密
     * @param strSrc
     * @return
     */
    public static String sha256(String strSrc) {
        MessageDigest md = null;
        String strDes = null;
        String encName = "SHA-256";
        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance(encName);
            md.update(bt);
            strDes = bytes2Hex(md.digest()); // to HexString
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    /**
     * 二进制字节,转换为16进制字符串,字母小写
     * @param bts
     * @return
     */
    public static String bytes2Hex(byte[] bts) {
        StringBuilder builder = new StringBuilder();
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                builder.append("0");
            }
            builder.append(tmp);
        }
        return builder.toString();
    }

}
