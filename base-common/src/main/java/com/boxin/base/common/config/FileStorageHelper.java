package com.boxin.base.common.config;

import com.boxin.base.common.util.DateUtil;
import com.boxin.base.common.util.PropertiesUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 文件存储配置信息
 * <p>
 *     需要如下这些信息:
 *     临时文件目录。
 *
 * </p>
 * Created by zy on 2015/5/9.
 */
public class FileStorageHelper {

	// 文件存储配置信息Properties文件名
	private static final String storageBundle = "filestorage";
	// 配置信息
	private static Map<String, String> configMap = new HashMap<String,String>();
	private static boolean hasInit = false;
	/**
	 * 加载配置文件信息.
	 * @param resName 基本的资源名字,如 "config/upload"
	 */
	public static synchronized void loadConfigFile(String resName){
		//
		Map<String, String> values  = PropertiesUtil.parseBundle2Map(resName);
		//
		configMap = (values);
		//
		hasInit = true;
	}

	public static void loadConfigFile(){
		String resName = storageBundle;
		loadConfigFile(resName);
	}

	public static synchronized void checkInit(){
		if(hasInit){
			return;
		}
		loadConfigFile();
	}

	public static String get(String configKey){
		checkInit();
		String value =  configMap.get(configKey);
		return  value;
	}
	/**
	 * Web 服务器的基础下载Path
	 * @return
	 */
	public static String webBaseDownPath(){
		return get("webBaseDownPath");
	}
	/**
	 * Web 服务器中保存文件的Base目录
	 * @return
	 */
	public static String baseSaveDirectory(){
		return get("baseSavePath");
	}

	public static File baseSaveDir(){
		//
		String baseSaveDirectory = baseSaveDirectory();
		File dir = new File(baseSaveDirectory);
		// 创建目录
		if (!dir.exists()){
			dir.mkdirs();
		}
		// 如果是文件,则获取父路径
		if (dir.isFile()){
			dir = dir.getParentFile();
		}
		//
		return  dir;
	}

	/**
	 * 主机ID
	 * @return
	 */
	public static String hostId(){
		return get("hostId");
	}

	/**
	 * 获取下一个文件ID; 时间戳+{3,6}位随机数字
	 * @return
	 */
	public static String nextFileId(){
		//
		String timestamp = DateUtil.currentTimpestamp();
		//
		Random random = new Random();

		int r = random.nextInt(4); // 0-3
		int n = 3 + r;

		//
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			//
			int r2 = random.nextInt(10); // 0-9
			sb.append(r2);
		}
		String rstr = sb.toString();
		//
		return  timestamp + rstr;
	}

	/**
	 * 计算相对Path, 封装内部实现算法
	 * @param fileId
	 * @return
	 */
	public static String hashPath(String fileId){
		//
		String hash = ""+ fileId.hashCode();
		//
		String timestamp = DateUtil.currentTimpestamp();
		//
		hash = timestamp.substring(0,6);

		//
		return  hash + "/";
	}

}
