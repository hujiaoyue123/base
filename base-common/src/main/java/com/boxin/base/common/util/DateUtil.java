package com.boxin.base.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	   * 格式化日期为字符串的函数.
	   *
	   * @param  date  日期.
	   * @param  format  转换格式，如："yyyy-MM-dd mm:ss"。
	   * @return   格式化后的日期字符串.
	   */
	  public static String formatDate(Date date, String format) {
	    if (date == null) {
	      return "";
	    }
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
	    return simpleDateFormat.format(date);
	  }

	  /**
	   * 格式化字符串为日期的函数.
	   *
	   * @param  str  字符串.
	   * @param  format  转换格式如:"yyyy-MM-dd mm:ss"
	   * @return  字符串包含的日期.
	   */
	  public static Date parseDate(String str, String format) {
	    try {
	      if (str == null || str.equals("")) {
	        return null;
	      }
	      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
	      return simpleDateFormat.parse(str);
	    }
	    catch (Exception e) {
	      //LogWriter.write(e);
	    }
	    return new Date();
	  }

	  /**
	   * 获取距离当前时间
	   * @param year
	   * @param month
	   * @param day
	   * @param hour
	   * @param min
	   * @param sec
	   * @return
	   */
	  public static Date getDate(Date date,int year,int month,int day,int hour,int min,int sec){
		   Calendar c = Calendar.getInstance();
		   c.setTime(date);
		   c.add(Calendar.YEAR,  year);
		   c.add(Calendar.MONTH, month);
		   c.add(Calendar.DAY_OF_MONTH, day);
		   c.add(Calendar.HOUR, hour);
		   c.add(Calendar.MINUTE, min);
		   c.add(Calendar.SECOND, sec);
		   return c.getTime();
	  }

	/**
	 * 获取给定日期的下一天对应时刻
	 * @param srcDay
	 * @return
	 */
	public static Date nextDate(Date srcDay){
		Date destDay = null;
		//
		Calendar c = Calendar.getInstance();
		c.setTime(srcDay);
		c.add(Calendar.DATE, 1);

		destDay = c.getTime();
		return destDay;
	}

	/**
	 * 获取明天此时
	 * @return
	 */
	public static Date tomorrow(){
		Date srcDay = new Date();
		return nextDate(srcDay);
	}

	/**
	 * 获取昨天此时
	 * @return
	 */
	public static Date yesterday(){
		Date srcDay = new Date();
		return prevDate(srcDay);
	}

	/**
	 * 获取给定日期的下一天对应时刻
	 * @param srcDay
	 * @return
	 */
	public static Date prevDate(Date srcDay){
		Date destDay = null;
		//
		Calendar c = Calendar.getInstance();
		c.setTime(srcDay);
		c.add(Calendar.DATE, 1);

		destDay = c.getTime();
		return destDay;
	}


	// 获取日期的起始时刻, 根据业务需要,不需要太精确
	public static final Date startOfDate(Date date){
		if(null == date){
			date = new Date();
		}
		//
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// 0时0分0秒
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		//
		//calendar.add(Calendar.MILLISECOND, -1);
		//
		Date d = calendar.getTime();
		//
		return d;
	}

	// 获取日期的结束时刻, 根据业务需要,不需要太精确
	public static final Date endOfDate(Date date){
		if(null == date){
			date = new Date();
		}
		//
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// 0时0分0秒
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.set(Calendar.MILLISECOND, 999);

		//calendar.add(Calendar.MILLISECOND, 1);
		//
		Date d = calendar.getTime();
		//
		return d;
	}

	// 私有 final属性域
	private static final SimpleDateFormat timestampFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	/**
	 * 获取当前时间戳, 格式 yyyyMMddHHmmssSSS
	 * @return
	 */
	public static final String currentTimpestamp(){
		//
		Date date = new Date();
		return  getTimpestamp(date);
	}

	/**
	 * 获取时间戳, 格式 yyyyMMddHHmmssSSS
	 * @param date
	 * @return
	 */
	public static final String getTimpestamp(Date date){
		//
		if(null == date){
			date = new Date();
		}
		//
		return  timestampFormat.format(date);
	}
}
