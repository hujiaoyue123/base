package com.boxin.base.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.boxin.base.model.ManageUser;
import com.boxin.base.service.manage.user.UserService;


public class QuartzJob1 implements Job {
	
	@Autowired
	UserService userservice;

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		ManageUser user = new ManageUser();
		user.setName(UUID.randomUUID().toString());
		user.setPassword("1");
		try {
			System.out.println("睡觉30秒"+userservice);
			new Thread().sleep(30000);
			System.out.println("执行时间" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			if(userservice != null){
				userservice.quartzTest(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
