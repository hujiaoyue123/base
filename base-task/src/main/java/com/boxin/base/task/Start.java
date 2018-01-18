package com.boxin.base.task;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Start {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
//		new ClassPathXmlApplicationContext("applicationContext-quartz.xml");
		  
		  try {  
//	        	 new ClassPathXmlApplicationContext("spring-quartz.xml");
	             String job_name = "job1";  
//	             System.out.println("【系统启动】开始(每1秒输出一次)...");    
	             QuartzManager.addJob(job_name, QuartzJob.class, "0/5 * * * * ?");
	             String job_name1 = "job2";
	             QuartzManager.addJob(job_name1, QuartzJob1.class, "0/5 * * * * ?"); 
	             
//	             Thread.sleep(5000);    
//	             System.out.println("【修改时间】开始(每2秒输出一次)...");    
//	             QuartzManager.modifyJobTime(job_name, "0/3 * * * * ?");   
//	             QuartzManager.modifyJobTime(job_name, "EXTJWEB_TRIGGERGROUP_NAME" ,"0/4 * * * * ?");    
//	             Thread.sleep(6000);    
//	             System.out.println("【移除定时】开始...");    
//	             QuartzManager.removeJob("资金");    
//	             System.out.println("【移除定时】成功");    
//	               
//	             System.out.println("【再次添加定时任务】开始(每10秒输出一次)...");    
//	             QuartzManager.addJob(job_name, QuartzJob.class, "0/3 * * * * ?");
//	             QuartzManager.startJobs();
//	             Thread.sleep(1000);    
//	             System.out.println("【移除定时】开始...");    
//	             QuartzManager.removeJob(job_name);    
//	             System.out.println("【移除定时】成功");  
	         } catch (Exception e) {  
	             e.printStackTrace();  
	         } 
		
	}

}
