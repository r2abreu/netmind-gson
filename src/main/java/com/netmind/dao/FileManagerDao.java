
package com.netmind.dao;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class FileManagerDao {

	private static File file = null;

	private static HashMap<String, File> filesCollection = new HashMap<String, File>();

	public static void createFile(String fileName) {
		file = new File(fileName);

		try {
			if (file.createNewFile()) {
				System.out.println("File is created!");
				if (fileName.contains(".txt")) {
					filesCollection.put("txt", file);

				} else if (fileName.contains(".json")) {
					filesCollection.put("json", file);
				}
			} else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static String getFileName(String extension) {
		file = filesCollection.get(extension);

		return file.getName();
	}

}