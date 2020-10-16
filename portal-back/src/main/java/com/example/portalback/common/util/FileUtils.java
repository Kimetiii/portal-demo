package com.example.portalback.common.util;

import java.io.File;

/**
 * @author songsenior
 * @date 2020/10/16 14:25
 * @Description:
 */
public class FileUtils {
	/*判断文件是否存在*/
	public static boolean isExists(String filePath) {
		File file = new File(filePath);
		return file.exists();
	}

	/*判断是否是文件夹*/
	public static boolean isDir(String path) {
		File file = new File(path);
		if(file.exists()){
			return file.isDirectory();
		}else{
			return false;
		}
	}
	/**
	 * 删除文件
	 * @param fileName
	 * @return
	 */

	public static boolean delete (String fileName){
		try{
			File sourceFile = new File(fileName);
			if(sourceFile.isDirectory()){
				for (File listFile : sourceFile.listFiles()) {
					delete(listFile.getAbsolutePath());
				}
			}
			return sourceFile.delete();
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}


	public static boolean  deleteFile(String sPath) {
		boolean flag = false;
		File file = new File(sPath);
		// 路径为文件且不为空则进行删除
		if (file.isFile() && file.exists()) {
			file.delete();
			flag = true;
		}
		return flag;
	}

}
