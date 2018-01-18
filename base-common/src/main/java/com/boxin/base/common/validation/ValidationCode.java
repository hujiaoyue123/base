package com.boxin.base.common.validation;

import com.boxin.base.common.util.StringUtil;
import org.patchca.color.ColorFactory;
import org.patchca.filter.predefined.*;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.utils.encoder.EncoderHelper;
import org.patchca.word.RandomWordFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码工具类
 * Created by zy on 2015/4/30.
 */

public class ValidationCode{

    public static String valToken_default = "ValidationCode_valToken_default";
    private static ConfigurableCaptchaService cs = new ConfigurableCaptchaService();
    private static Random random = new Random();
    static {
        cs.setColorFactory(new ColorFactory() {
            @Override
            public Color getColor(int x) {
                int[] c = new int[3];
                int i = random.nextInt(c.length);
                for (int fi = 0; fi < c.length; fi++) {
                    if (fi == i) {
                        c[fi] = random.nextInt(71);
                    } else {
                        c[fi] = random.nextInt(256);
                    }
                }
                return new Color(c[0], c[1], c[2]);
            }
        });
        RandomWordFactory wf = new RandomWordFactory();
        wf.setCharacters("23456789ABCDEFGHGKLMNPQRSTUVWXY");
        wf.setMaxLength(4);
        wf.setMinLength(4);
        cs.setWordFactory(wf);
    }

    /**
     * 输入验证码
     * @param request
     * @param response
     * @param valToken  验证码存储在Session中的名称
     * @throws IOException
     */
    public static void pushValidationCode(HttpServletRequest request, HttpServletResponse response,String valToken) throws IOException {
        switch (random.nextInt(5)) {
            case 0:
                cs.setFilterFactory(new CurvesRippleFilterFactory(cs.getColorFactory()));
                break;
            case 1:
                cs.setFilterFactory(new MarbleRippleFilterFactory());
                break;
            case 2:
                cs.setFilterFactory(new DoubleRippleFilterFactory());
                break;
            case 3:
                cs.setFilterFactory(new WobbleRippleFilterFactory());
                break;
            case 4:
                cs.setFilterFactory(new DiffuseRippleFilterFactory());
                break;
        }
        HttpSession session = request.getSession(true);
        setResponseHeaders(response);
        String token = EncoderHelper.getChallangeAndWriteImage(cs, "png", response.getOutputStream());
        //
        valToken = geneValToken(valToken);
        session.setAttribute(valToken, token);
        session.setAttribute("times", 0);
    }

    /**
     * 输入验证码
     * @param request
     * @param response
     * @throws IOException
     */
    public static void pushValidationCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        pushValidationCode(request, response, "");
    }

    //
    public static String geneValToken(String valToken){
        if(null == valToken || valToken.trim().isEmpty()){
            valToken = valToken_default;
        }
        //
        return valToken;
    }

    /**
     * 判断验证码正确与否
     * @param request
     * @param valToken  session中存验证码的名称
     * @param code      用户输入的验证码
     * @return
     * @throws Exception
     */
    public static boolean validate(HttpServletRequest request,String valToken,String code){
        HttpSession hSession = request.getSession();
        if(hSession == null){           //session为空返回false
            return false;
        }
        valToken = geneValToken(valToken);
        Object hcode = hSession.getAttribute(valToken);
        if(hcode == null){
            return false;
        }
        String  scode = hcode.toString();
        if(StringUtil.isBlank(scode)){   //session中得到验证码为空，也返回false
            return false;
        }
        boolean checkOK = code.equalsIgnoreCase(scode);
        int times = Integer.parseInt(hSession.getAttribute("times").toString());

        if(times <3 && times >=0){
            hSession.setAttribute("times", times + 1);
        }else if(times >=3){
            hSession.removeAttribute(valToken); // 移除session中的验证码
        }
//        if(checkOK){
//            hSession.removeAttribute(valToken); // 移除session中的验证码
//        }
        return checkOK;
    }

    /**
     * 判断验证码正确与否
     * @param request
     * @param code      用户输入的验证码
     * @return
     * @throws Exception
     */
    public static boolean validate(HttpServletRequest request,String code){
        return validate(request,"",code);
    }


    /**
     * 设置输出时参数
     * @param response
     */
    protected static void setResponseHeaders(HttpServletResponse response) {
        response.setContentType("image/png");
        response.setHeader("Cache-Control", "no-cache, no-store");
        response.setHeader("Pragma", "no-cache");
        long time = System.currentTimeMillis();
        response.setDateHeader("Last-Modified", time);
        response.setDateHeader("Date", time);
        response.setDateHeader("Expires", time);
    }


}
