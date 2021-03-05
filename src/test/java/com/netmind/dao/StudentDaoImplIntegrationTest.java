package com.netmind.dao;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.netmind.dao.contracts.StudentDao;
import com.netmind.model.Student;

public class StudentDaoImplIntegrationTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		FileManagerDao.createFile("alumno.json");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddToJsonFile() {
		StudentDao studentDao = new StudentDaoImpl();

		Student student = new Student();

		studentDao.add(student);

		fail("Not yet implemented");
	}

}
