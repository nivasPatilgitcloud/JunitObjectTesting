package com.spring.junitobjtesting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.junitobjtesting.entity.Student;
import com.spring.junitobjtesting.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	private StudentService studentService;
	@PostMapping("/savestudent")
	public Student saveStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
}
