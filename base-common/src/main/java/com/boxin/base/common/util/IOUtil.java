package com.boxin.base.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * IO工具类.
 * @author  zy
 * @since  2015/4/27
 * @version 0.0.1
 */
public abstract class IOUtil {
	// 日志
	private static final Log logger = LogFactory.getLog(IOUtil.class);

	/**
	 * 关闭输出流
	 * @param outputStream
	 */
	public static void close(OutputStream outputStream){
		if(null != outputStream){
			try {
				outputStream.close();
			} catch (IOException e) {
				logger.error("关闭 outputStream 出错.",e);
			}
		}
	}
	/**
	 * 关闭输入流
	 * @param inputStream
	 */
	public static void close(InputStream inputStream){
		if(null != inputStream){
			try {
				inputStream.close();
			} catch (IOException e) {
				logger.error("关闭 inputStream 出错.",e);
			}
		}
	}
}
