package com.boxin.base.web.controller.common;

import com.boxin.base.common.util.JsonUtil;
import com.boxin.base.common.util.StringUtil;
import com.boxin.base.common.util.WebUtil;
import com.boxin.base.common.validation.PhoneValidationCode;
import com.boxin.base.common.validation.ValidationCode;
import com.boxin.base.mc.MessageSender;
import com.boxin.base.mc.message.SMSMessage;
import com.boxin.base.mc.SimpleMessageSender;
import com.boxin.base.mc.sender.SMSSender;
import com.boxin.base.webmodel.ResultData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 公用控制类
 * Created by zy on 2015/5/2.
 */
@Controller
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private SMSSender smsSender;

    Log logger = LogFactory.getLog(PublicController.class);

    public static String PUBLIC_SUCCESS = "0";
    public static String PUBLIC_FAILD = "1";
    public static String PUBLIC_PARAM_ERROR = "2";

    /**
     * 获取验证码; 前端请在使用时添加随机参数防止缓存 <br/>
     * 验证时直接使用ValidationCode.validate(request,userInputCode)判断验证码是否有效
     * @param request
     * @param response
     */
    @RequestMapping("/verifycode.png.do")
    public void getCode(HttpServletRequest request,HttpServletResponse response){
        try {
            ValidationCode.pushValidationCode(request, response);

        } catch (IOException e){
            logger.error(e.getMessage(),e);
        }
    }

    /**
     * 向手机phone发送消息msg
     * @param phone
     * @param msg
     * @return
     * @throws Exception
     */
    public  boolean sendPhoneMsg(String phone,String msg) throws Exception {
        boolean result = false;
        try{
            SMSMessage message = new SMSMessage();
            message.setText(msg.toString());
            message.setTo(new String[]{phone});
            MessageSender sender = new SimpleMessageSender(smsSender);
            result = sender.sendTextMessage(message);
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            result = false;
        }
        return result;
    }


    /**
     * 请求发送手机验证码
     * @param request(包含参数phone手机号)
     * @param response
     */
    @RequestMapping(value = "sendPhoneVerifycode.json")
    public void sendPhoneVerifycode(HttpServletRequest request,HttpServletResponse response){
        Map<String,String> paramMap = WebUtil.parseParamMap(request);
        String phone = paramMap.get("phone");
//      String lang = paramMap.get("lang");
        ResultData resultData = ResultData.newInstance();
        if(StringUtil.isEmpty(phone) && !StringUtil.isPhone(phone)){
            resultData.setAsFailure();
            resultData.setMessage(PUBLIC_PARAM_ERROR);
            WebUtil.write(response, JsonUtil.obj2JsonObj(resultData));
            return ;
        }
        String verifyCode = PhoneValidationCode.getPhoneValidationCode(request, response);
        StringBuffer msg = new StringBuffer();
        msg.append("The ezuglobal platform send message:");
        msg.append("your phone verifycode is ").append(verifyCode);

        boolean b = false;
        try{
            b = sendPhoneMsg(phone, msg.toString());
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            resultData.setAsFailure();
            resultData.setMessage(PUBLIC_FAILD);
        }

        if(b){
            resultData.setAsSuccess();
            resultData.setMessage(PUBLIC_SUCCESS);
        }else{
            resultData.setAsFailure();
            resultData.setMessage(PUBLIC_FAILD);
        }
        WebUtil.write(response, JsonUtil.obj2JsonObj(resultData));
    }


}
