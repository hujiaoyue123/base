package com.boxin.base.common.util;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zy on 2015/4/20.
 */
public class StringUtil {

    private static final Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    /**
     * 判断字符串是否为邮件格式
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
        if(isEmpty(email)){
            return false;
        }
        Matcher matcher = emailPattern.matcher(email);
        if (matcher.matches()){
            return true;
        }
        return false;
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        if(null==str||str.trim().isEmpty()
                ||"null".equalsIgnoreCase(str.trim()) || "undefined".equalsIgnoreCase(str.trim()) ){
            return true;
        }
        return false;
    }

    public static boolean isEmpty(Object obj){
        return null== obj || isEmpty(obj.toString());
    }
    /**
     * 功能描述：接受一个List<String>，如果有任何一个为空，则返回true，否则返回false
     * @param list
     * @return
     */
    public static boolean isBlank(String... list){
        for (String string : list) {
            if(StringUtils.isBlank(string)){
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否为手机号
     * @param phone
     * @return
     */
    public static boolean isPhone(String phone){
        if(isEmpty(phone)){
            return false;
        }
        // (+86)170xxxx
        // +86171xxxx
        // +852 95150805
        String telRegex = "(\\(?\\+\\d{1,5}\\)?)?\\d{5,20}"; // 这个正则还有问题
        return phone.matches(telRegex);
    }

    /**
     * 判断是否是整型数字
     * @param num
     * @return
     */
    public static boolean isLong(String num){
        if(isEmpty(num)){
            return false;
        }
        String telRegex = "[\\+\\-]?\\d+";
        return num.matches(telRegex);
    }

    /**
     * 判断是否为空
     */
    public static boolean notEmpty(String str) {
        boolean b = false;
        if(null != str && !"".equals(str.trim())) {
            b = true;
        }
        return b;
    }

    /**
     * 转换为字符串,去除首尾空格,为空则返回空串
     * @param obj
     * @return
     */
    public static String toString(Object obj){
        if(isEmpty(obj)){
            return "";
        }
        return obj.toString().trim();
    }

    /**
     * 判断字符串是否为数字串
     * @param str
     * @return
     */
    public static boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }
}
