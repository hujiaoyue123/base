package com.boxin.quartz.core;

import com.boxin.quartz.support.Job2;




/**
 * 自定义Job,实现扩展的Job2，
 * 
 */
public class MyBusiJob implements Job2{

	private static int count = 1 ;
	
	private CustService custService ;
	
	public void executeInternal() {
		custService.save("cust " + count);
		
		count ++ ;
	}

	public void setCustService(CustService custService) {
		this.custService = custService;
	}

}
