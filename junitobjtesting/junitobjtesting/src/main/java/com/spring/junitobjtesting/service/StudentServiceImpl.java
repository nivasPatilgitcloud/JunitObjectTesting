package com.spring.junitobjtesting.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.junitobjtesting.entity.Student;
import com.spring.junitobjtesting.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.save(student);
	}

	@Override
	public List<Student> showAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public void getStudent(int id) {
		// TODO Auto-generated method stub
		Optional<Student> getstudentId = studentRepo.findById(id);
		if(getstudentId.isPresent()) {
			Student student = getstudentId.get();
			System.out.println(student);
		}
	}

}
