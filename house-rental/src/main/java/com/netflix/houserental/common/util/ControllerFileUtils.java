package com.netflix.houserental.common.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;

/**
 * <p>controller file 
 * @see ControllerFileUtils
 *
 */
public class ControllerFileUtils {

	private static final File  TEMP_DIR=Files.createTempDir();
	
	/**
	 * 
	 * @param srcs
	 * @return destFiles
	 * @throws IOException
	 */
	public static List<File> transferToFileList(MultipartFile[] srcs) throws IOException {

		List<File> destFiles = new ArrayList<File>();
		for (MultipartFile multiPartFile : srcs) {
			destFiles.add(transferToFile(multiPartFile));
		}
		return destFiles;

	}

	/**
	 * 
	 * @param src
	 * @return destFile
	 * @throws IOException
	 */
	public static File transferToFile(MultipartFile src) throws IOException {
		String name = src.getOriginalFilename();
		String filePath = TEMP_DIR.getPath()+ File.separator + name;
		File dest = new File(filePath);
		src.transferTo(dest);
		return dest;

	}


	/**
	 * 
	 * @throws IOException 
	 */
	public static void deleteTempFiles() throws IOException {
		  if (TEMP_DIR.exists()) {
			  FileUtils.cleanDirectory(TEMP_DIR);
	        }
	}

}
