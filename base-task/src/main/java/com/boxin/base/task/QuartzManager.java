package com.boxin.base.task;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** 
 * @Description: 定时任务管理类 
 *  
 * @ClassName: QuartzManager 
 */  
public class QuartzManager {  
	private final static Logger logger = LoggerFactory.getLogger(QuartzManager.class);
    private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();  
    private static String JOB_GROUP_NAME = "YC_JOBGROUP_NAME";  
    private static String TRIGGER_GROUP_NAME = "YC_TRIGGERGROUP_NAME";  
  
    /** 
     * @Description: 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名 
     *  
     * @param jobName 
     *            任务名 
     * @param cls 
     *            任务 
     *  
     */  
    public static void addJob(String jobName, Class cls, String time) throws Exception {  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, cls);// 任务名，任务组，任务执行类  
            // 触发器  
            CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);// 触发器名,触发器组  
            trigger.setCronExpression(time);// 触发器时间设定  
            jobDetail.setRequestsRecovery(true);
            sched.scheduleJob(jobDetail, trigger);  
            // 启动  
            if (!sched.isShutdown()) {  
                sched.start();  
            }  
        } catch (Exception e) {  
            // 按新的trigger重新设置job执行
        	logger.error(e.getMessage(), e);
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * @Description: 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名) 
     *  
     * @param jobName 
     * @param time 
     *  
     * @Title: QuartzManager.java 
     */  
    public static void modifyJobTime(String jobName, String time) throws Exception{  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            CronTrigger trigger = (CronTrigger) sched.getTrigger(jobName,TRIGGER_GROUP_NAME);  
            if (trigger == null) {  
                return;  
            }  
            String oldTime = trigger.getCronExpression();  
            if (!oldTime.equalsIgnoreCase(time)) {  
                JobDetail jobDetail = sched.getJobDetail(jobName,JOB_GROUP_NAME);  
                Class objJobClass = jobDetail.getJobClass();  
                removeJob(jobName);  
                Thread.sleep(2000);
                addJob(jobName, objJobClass, time);  
            }  
        } catch (Exception e) {  
        	logger.error(e.getMessage(), e);
            throw new RuntimeException(e);  
        }  
    }  
  
  
    /** 
     * @Description: 移除一个任务(使用默认的任务组名，触发器名，触发器组名) 
     *  
     * @param jobName 
     *  
     */  
    public static void removeJob(String jobName) throws Exception{  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            sched.pauseTrigger(jobName, TRIGGER_GROUP_NAME);// 停止触发器  
            sched.unscheduleJob(jobName, TRIGGER_GROUP_NAME);// 移除触发器  
            sched.deleteJob(jobName, JOB_GROUP_NAME);// 删除任务  
        } catch (Exception e) {  
        	logger.error(e.getMessage(), e);
            throw new RuntimeException(e);  
        }  
    }  
  
  
    /** 
     * @Description:恢复定时任务
     * 
     */  
    public static void resumeJobs(String triggerName) throws Exception{  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            sched.resumeTrigger(triggerName, TRIGGER_GROUP_NAME);
            
        } catch (Exception e) {  
        	logger.error(e.getMessage(), e);
            throw new RuntimeException(e);  
        }  
    }  
  
    /** 
     * @Description:暂停定时任务 
     *  
     */  
    public static void pauseJobs(String triggerName) throws Exception {  
        try {  
            Scheduler sched = gSchedulerFactory.getScheduler();  
            sched.pauseTrigger(triggerName, TRIGGER_GROUP_NAME);// 停止触发器  
       } catch (Exception e) {  
    	    logger.error(e.getMessage(), e);
            throw new RuntimeException(e);  
        }  
    }  
    
    /**
	 * 启动所有任务
	 */
 	public static void startJobs(){
 		
 		 try {
			Scheduler sched = gSchedulerFactory.getScheduler();
			sched.resumeAll();
			sched.start();
		} catch (SchedulerException e) {
			 logger.error(e.getMessage(), e);
	         throw new RuntimeException(e); 
		}  
 		
 	}
 	
}  

	
	
/**
 * state的值代表该任务触发器的状态：
   STATE_BLOCKED  4
   STATE_COMPLETE  2
   STATE_ERROR  3 
   STATE_NONE  -1
   STATE_NORMAL  0
   STATE_PAUSED  1 
 */
