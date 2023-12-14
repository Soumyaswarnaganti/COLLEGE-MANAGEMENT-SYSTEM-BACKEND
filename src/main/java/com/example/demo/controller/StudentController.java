package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StudentController {

	@Autowired
	private final StudentService studentService;
	
	@PostMapping("/student")
	public Student postStudent(@RequestBody Student student) {
		return studentService.postStudent(student);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@DeleteMapping("/student/{id}")
	public void deleteStudent(@PathVariable long id) {
		studentService.deleteStudent(id);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable long id) {
		Student student = studentService.getStudentById(id);
		if(student==null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(student);
				
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable long id,@RequestBody Student student){
		Student updatedStudent = studentService.updateStudent(id, student);
		if(updatedStudent==null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(updatedStudent);
	}
}
