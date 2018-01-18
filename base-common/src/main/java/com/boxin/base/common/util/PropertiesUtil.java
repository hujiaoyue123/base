package com.boxin.base.common.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by zy on 2015/5/16.
 */
public class PropertiesUtil {

	/**
	 * 将 Properties解析为Map
	 * @param baseName
	 * @return
	 */
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

}
