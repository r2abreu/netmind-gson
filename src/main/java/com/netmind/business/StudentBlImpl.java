package com.netmind.business;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;

import com.netmind.business.contracts.StudentBl;
import com.netmind.dao.FileManagerDao;
import com.netmind.dao.StudentDaoImpl;
import com.netmind.dao.contracts.StudentDao;
import com.netmind.model.Student;

public class StudentBlImpl implements StudentBl {

	static Logger logger = Logger.getLogger(StudentBlImpl.class);
	static Properties prop = null;

	static InputStream input = null;
	private static ArrayList<Student> studentList = null;
	static JSONArray studentJsonList = null;

	static {
		studentList = new ArrayList<Student>();
		studentJsonList = new JSONArray();
	}

	static {
		prop = new Properties();

		try {
			input = StudentBlImpl.class
					.getResourceAsStream("/config.properties");
			prop.load(input);
		} catch (IOException e) {
			logger.error(e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}

	@Override
	public boolean add(Student student) throws IOException {
		StudentDao studentDao = new StudentDaoImpl();

		student.setAge(calculateAge(student.getDateOfBirth()));

		FileManagerDao.createFile(prop.getProperty("TxtFilename"));
		logger.info("txt file is created");

		return studentDao.addStudentToFile(student);
	}

	private int calculateAge(LocalDate dateOfBirth) {
		Period age = Period.between(dateOfBirth, LocalDate.now());
		return age.getYears();
	}

	@Override
	public boolean addToJsonFile(Student student) throws IOException {

		StudentDao studentDao = new StudentDaoImpl();

		FileManagerDao.createFile(prop.getProperty("JsonFilename"));
		logger.info("json file is created");

		return studentDao.addToJsonFile(student);
	}
}
