package com.boxin.base.common.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * Created by zy on 2015/4/20.
 */
public class JsonUtil {

    /**
     * 将map转换为json 字符串
     * @param map
     * @return
     */
    public static String map2Json(Map map){
        JSONObject jsonObject = new JSONObject();
        jsonObject.putAll(map == null || map.isEmpty() ? new HashMap() : map);
        return jsonObject.toString();
    }

    /**
     * 将list转换为json 字符串
     * @param list
     * @return
     */
    public static String list2Json(List list){
        JSONArray jsonArray = JSONArray.fromObject(list == null || list.isEmpty() ? new ArrayList() : list);
        return jsonArray.toString();
    }

    /**
     * 将JSON格式的字符串转化为Map对象，只进行第一层次的转换
     * @param json
     * @return
     */
    public static Map<String,String> json2SimpleMap(String json){
        JSONObject object = JSONObject.fromObject(json);
        Map map = new HashMap();
        Iterator it = object.keys();
        while (it.hasNext()) {
            String key = (String)it.next();
            map.put(key, ConvertUtil.obj2Str(object.get(key)));
        }
        return map;
    }

    /**
     * 将JSON格式的字符串转化为Map对象，进行所有层次的转换
     * @param json
     * @return
     */
    public static Map<String, Object> json2Map(String json){
        if(StringUtil.isEmpty(json)){
            return null;
        }
        JSONObject object = JSONObject.fromObject(json);
        Map map = new HashMap();
        Iterator it = object.keys();
        while (it.hasNext()) {
            String key = (String)it.next();
            String value = object.getString(key);
            //如果为Map结构
            if (JSONUtils.isObject(object.get(key))) {
                map.put(key, json2Map(value));
                //如果为List结构
            } else if (JSONUtils.isArray(object.get(key))) {
                List<Map> list = new ArrayList<Map>();
                JSONArray jArray = JSONArray.fromObject(value);
                for (int i = 0; i < jArray.size(); i++) {
                    list.add(json2Map(jArray.getString(i)));
                }
                map.put(key, list);
            } else {
                map.put(key, ConvertUtil.obj2Str(object.get(key)));
            }
        }
        return map;
    }

    /**
     * json 转换为list
     * @param json
     * @return
     */
    public static List<Map> json2List(String json){
        if (StringUtils.isBlank(json)) {
            return new ArrayList<Map>();
        }
        JSONArray jArray = JSONArray.fromObject(json);
        List<Map> list = new LinkedList<Map>();
        for (int i = 0; i < jArray.size(); i++) {
            list.add(json2Map(jArray.getString(i)));
        }
        return list;
    }

    /**
     * 将对象转换为JSON格式的字符串
     * @param obj
     * @return
     */
    public static String obj2Json(Object obj) {
        JSONArray jsonArray = JSONArray.fromObject(obj);
        return jsonArray.toString();
    }
    public static String obj2JsonObj(Object obj) {
        JSONObject jsonArray = JSONObject.fromObject(obj);
        return jsonArray.toString();
    }
}
