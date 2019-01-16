package com.netflix.houserental.common.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;


/**
 * <p>controller file 
 * @see ControllerFileUtils
 *
 */
public class ControllerFileUtils {

	//private static final File  TEMP_DIR=Files.createTempDir();

    private static final File  TEMP_DIR=new File("D:\\development\\nginx-1.15.8\\html");


	/**
	 * 
	 * @param srcs 文件数组
	 * @return destFiles
	 * @throws IOException io Exception
	 */
	public static List<File> transferToFileList(MultipartFile[] srcs) throws IOException {

		List<File> destFiles = new ArrayList<>();
		for (MultipartFile multiPartFile : srcs) {
			destFiles.add(transferToFile(multiPartFile));
		}
		return destFiles;

	}

	/**
	 * 
	 * @param src 文件
	 * @return destFile
	 * @throws IOException io exception
	 */
	public static File transferToFile(MultipartFile src) throws IOException {
		String name = src.getOriginalFilename();
        assert name != null;
        String newName=new Date().getTime()+name.substring(name.indexOf("."));
        String filePath = TEMP_DIR.getPath()+ File.separator + newName;
		File dest = new File(filePath);
		src.transferTo(dest);
		return dest;

	}


	/**
	 * 
	 * @throws IOException io exception
	 */
	public static void deleteTempFiles() throws IOException {
		  if (TEMP_DIR.exists()) {
			  FileUtils.cleanDirectory(TEMP_DIR);
	        }
	}

}
