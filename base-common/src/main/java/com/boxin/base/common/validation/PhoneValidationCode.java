package com.boxin.base.common.validation;

import com.boxin.base.common.util.MathUtil;
import com.boxin.base.common.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by zy on 2015/5/27.
 */
public class PhoneValidationCode {

    public static String phone_ValToken_default = "Phone_ValidationCode_valToken_default";

    /**
     * 返回手机验证码并将验证码存储到session当中
     * @param request
     * @param response
     * @return
     */
    public static String getPhoneValidationCode(HttpServletRequest request,HttpServletResponse response){
        HttpSession session = request.getSession(true);
        String verifyCode = MathUtil.getSpecifyLengthDigit(6);
        session.setAttribute(phone_ValToken_default,verifyCode);
        session.setAttribute("datetime",verifyCode);
        return verifyCode;
    }

    /**
     * 判断验证码正确与否
     * @param request
     * @param code  用户输入的验证码
     * @return
     */
    public static boolean validate(HttpServletRequest request,String code){
        HttpSession hSession = request.getSession();
        if(hSession == null){           //session为空返回false
            return false;
        }
        Object hcode = hSession.getAttribute(phone_ValToken_default);
        if(hcode == null){
            return false;
        }
        String  scode = hcode.toString();
        if(StringUtil.isBlank(scode)){   //session中得到验证码为空，也返回false
            return false;
        }
        boolean checkOK = code.equals(scode);
        if(checkOK){
            hSession.removeAttribute(phone_ValToken_default); // 移除session中的验证码
        }
        return checkOK;
    }

}
