
package com.netmind.dao;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FileManagerDao {

	private static File file = null;

	private static HashMap<String, File> filesCollection = new HashMap<String, File>();

	public static synchronized boolean createFile(String fileName)
			throws IOException {
		boolean isFileCreated = false;
		file = new File(fileName);

		if (!file.exists()) {
			try {
				isFileCreated = file.createNewFile();
				filesCollection.put("txt", file);
				filesCollection.put("json", file);
			} catch (IOException e) {
				System.out.println(e.getMessage());
				throw e;
			}
		}

		return isFileCreated;
	}

	public static String getFileName(String extension) {
		return filesCollection.get(extension).getName();
	}

}