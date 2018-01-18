package com.boxin.base.task;

import java.text.SimpleDateFormat;  
import java.util.Date;  

import org.quartz.Job;  
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
   
 /** 
  * @Description: 任务执行类 
  * 
  * @ClassName: QuartzJob 
  * 
  */  
 public class QuartzJob implements Job {  
   
	 
     @Override  
     public void execute(JobExecutionContext arg0) throws JobExecutionException {  
    	 
         System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ "★★★★★★★★★★★");    
         
     }  
 } 

