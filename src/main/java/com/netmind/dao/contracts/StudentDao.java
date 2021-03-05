package com.netmind.dao.contracts;

import java.io.IOException;

import com.netmind.model.Student;

public interface StudentDao {

	boolean add(Student student);

	boolean addToJsonFile(Student student);

	boolean addStudentToFile(Student student) throws IOException;
}
