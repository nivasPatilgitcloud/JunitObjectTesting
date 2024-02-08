package com.spring.junitobjtesting.studentapitest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.spring.junitobjtesting.entity.Student;
import com.spring.junitobjtesting.repository.StudentRepository;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class StudentTest {

	@Autowired
	StudentRepository studentRepo;
	@BeforeClass
	public static void init() {
		System.out.println("Student test case execution start");
	}
	
	//Create student test
	@Test
	@Order(1)
	public void saveStudentTest() {
		
		Student s = new Student();
		s.setId(10);
		s.setName("nivas");
		s.setEmail("nivaspatil@gmail.com");
		s.setPassword("nivaspatil");
		studentRepo.save(s);
		
		assertNotNull(studentRepo.findById(10).get());
	}
	//Read all students test
	@Test
	@Order(2)
	public void readStudentTest() {
		List<Student> studData = studentRepo.findAll();
		assertThat(studData).size().isGreaterThan(0);
	}
	
	//Read single student test
	//if name is not present then test case will get failed
	@Test
	@Order(3)
	public void readSingleStudentTest() {
		Student studData = this.studentRepo.findById(10).get();
		String actualData = studData.getName();
		Assert.assertEquals("nivas", actualData);
	}
	@Test
	@Order(4)
	public void updateStudentTest() {
		Student data = this.studentRepo.findById(10).get();
		data.setName("Nivas Shivaji Patil");
		this.studentRepo.save(data);
		assertNotEquals("nivas patil", this.studentRepo.findById(10).get().getName());
	}
//	@Test
//	@Order(5)
//	public void deleteStudentTest() {
//		this.studentRepo.deleteById(10);
//		assertThat(this.studentRepo.existsById(10)).isFalse();
//	}
	
	@AfterClass
	public static void cleanup() {
		System.out.println("Student test case execution end");
	}
}
