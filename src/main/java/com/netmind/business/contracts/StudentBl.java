package com.netmind.business.contracts;

import java.io.IOException;

import com.netmind.model.Student;

public interface StudentBl {

	boolean add(Student student) throws IOException;

	boolean addToJsonFile(Student student) throws IOException;

}
