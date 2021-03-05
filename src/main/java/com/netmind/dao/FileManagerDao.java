
package com.netmind.dao;

import java.io.File;
import java.io.IOException;

public class FileManagerDao {

	private static File file = null;

	public static synchronized boolean createFile(String fileName)
			throws IOException {
		boolean isFileCreated = false;
		file = new File(fileName);

		if (!file.exists()) {
			try {
				isFileCreated = file.createNewFile();
			} catch (IOException e) {
				System.out.println(e.getMessage());
				throw e;
			}
		}

		return isFileCreated;
	}

	public static String getFileName() {
		return file.getName();
	}

}