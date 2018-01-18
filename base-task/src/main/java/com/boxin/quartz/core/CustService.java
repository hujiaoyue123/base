package com.boxin.quartz.core;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 客户服务类
 * 
 */
public class CustService {

	
	public void save(String custName){
		
		// do persistence cust ...
	System.out.println("服务》》》" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+"※");
	}
}
