package com.spring.junitobjtesting.service;

import java.util.List;

import com.spring.junitobjtesting.entity.Student;

public interface StudentService {

	public Student saveStudent(Student student);
	
	public List<Student> showAllStudents();
	
	public void getStudent(int id);
}
