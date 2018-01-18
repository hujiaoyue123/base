package com.boxin.base.common.util;

import java.util.*;

/**
 * Created by zy on 2015/4/20.
 */
public class ConvertUtil {

    /**
     * obj to boolean
     * @param obj
     * @return
     */
    public static Boolean obj2Boolean(Object obj){
        return obj == null ? false : Boolean.getBoolean(obj.toString());
    }

    public static String obj2Str(Object obj) {
        return obj == null ? null : obj.toString();
    }

    /**
     * 泛型转换, 将 Map<String, String> 转换后返回一个 Map<String, Object>
     * @param map1
     * @return
     */
    public static Map<String, Object> mapString2Object(Map<String, String> map1){
        //
        Map<String, Object> map2 = new HashMap<String, Object>();
        //
        map2.putAll(map1);
        //
        return map2;
    }

    public static Map<String, String> parseBundle2Map(String baseName){
        Map<String, String> values = new HashMap<String, String>();
        //
        ResourceBundle bundle = ResourceBundle.getBundle(baseName);
        if(null == bundle){
            return values;
        }
        //
        Enumeration<String> keys =  bundle.getKeys();
        //
        if(null == keys){
            return values;
        }
        while (keys.hasMoreElements()) {
            String key = (String) keys.nextElement();
            String value = bundle.getString(key);
            //
            if(null == key || key.trim().isEmpty()){
                continue;
            }
            values.put(key, value);
        }
        //
        return values;
    }

    /**
     * 将List中的Key转换为小写
     * @param list 返回新对象
     * @return
     */
    public static List<Map<String, Object>> convertKeyList2LowerCase(List<Map<String, Object>> list){
        if(null==list) {
            return null;
        }
        List<Map<String, Object>> resultList = new ArrayList<Map<String,Object>>();
        //
        Iterator<Map<String, Object>> iteratorL = list.iterator();
        while (iteratorL.hasNext()) {
            Map<String, Object> map = (Map<String, Object>) iteratorL.next();
            //
            Map<String, Object> result = convertKey2LowerCase(map);
            if(null != result){
                resultList.add(result);
            }
        }
        //
        return resultList;
    }
    /**
     * 转换单个map,将key转换为小写.
     * @param map 返回新对象
     * @return
     */
    public static Map<String, Object> convertKey2LowerCase(Map<String, Object> map){
        if(null==map) {
            return null;
        }
        Map<String, Object> result = new HashMap<String, Object>();
        //
        Set<String> keys  = map.keySet();
        //
        Iterator<String> iteratorK = keys.iterator();
        while (iteratorK.hasNext()) {
            String key = (String) iteratorK.next();
            Object value = map.get(key);
            if(null == key){
                continue;
            }
            //
            String keyL = key.toLowerCase();
            result.put(keyL, value);
        }
        return result;
    }

}
