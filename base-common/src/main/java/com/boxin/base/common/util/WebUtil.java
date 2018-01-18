package com.boxin.base.common.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by zy on 2015/4/27.
 */
public class WebUtil {

    /**
     * 获取系统URL
     * @param request
     * @return
     */
    public static String getFullPath(HttpServletRequest request){
        return request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
    }

    /**
     * 以utf-8编码的格式向前端输出信息
     * @param response
     * @param str
     */
    public static void write(HttpServletResponse response, String str){
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer =response.getWriter();
            writer.print(str);
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解析request中的参数Map
     * @param request
     * @return
     */
    public static Map<String, Object> parseParamMapObject(HttpServletRequest request){
        //
        Map<String, String> map = parseParamMap(request);
        Map<String, Object> map2 = ConvertUtil.mapString2Object(map);
        //
        return map2;
    }

    public static Map<String, String> parseParamMap(HttpServletRequest request, boolean empty2null){

        Map<String, String> map = parseParamMap(request);
        if(empty2null){
            //
            Set<String> keySet = map.keySet();
            //
            Iterator<String> iteratorK = keySet.iterator();
            while(iteratorK.hasNext()){
                //
                String key = iteratorK.next();
                String value = map.get(key);
                if(null == value || value.trim().isEmpty()){
                    iteratorK.remove(); // 移除元素
                }
            }
        }
        //
        return map;
    }
    @SuppressWarnings("unchecked")
    public static Map<String, String> parseParamMap(HttpServletRequest request){
        //
        Map<String, String> map = new HashMap<String, String>();
        //
        if(null != request){
            Enumeration<String> enumeration = request.getParameterNames();
            // 遍历参数,其实有request的request.getParameterMap();但没泛型
            while (enumeration.hasMoreElements()) {
                String paraName = (String) enumeration.nextElement();
                //
                String paraValue = request.getParameter(paraName);
                //
                if(null != paraValue){
                    paraValue = paraValue.trim();
                }
                if("".equals(paraValue) || "null".equals(paraValue) || "undefined".equals(paraValue)){
                    paraValue = "";
                }
                map.put(paraName, paraValue);
            }
        }
        //
        return map;
    }
}
