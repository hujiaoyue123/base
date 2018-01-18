package com.boxin.quartz.support;

import java.io.Serializable;

import org.springframework.context.ApplicationContext;


/**
 * 引导Job，通过Spring容器获取任务的Job，根据注入的targetJob,该Job必须实现Job2接口
 * 
 */
public class BootstrapJob implements Serializable{

	private String targetJob ; 
	
	public void executeInternal(ApplicationContext cxt) {
		if(cxt != null){
			Job2 job = (Job2)cxt.getBean(this.targetJob);
			job.executeInternal() ;
		}
	}
	void testMethod2(){
		
	}

	public String getTargetJob() {
		return targetJob;
	}

	public void setTargetJob(String targetJob) {
		this.targetJob = targetJob;
	}
}

