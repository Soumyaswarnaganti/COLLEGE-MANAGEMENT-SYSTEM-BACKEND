package com.example.demo.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {

	@Autowired
	private final StudentRepository studentRepository;
	
	public Student postStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getAllStudent(){
		return studentRepository.findAll();
	}
	
	public void deleteStudent(long id) {
		studentRepository.deleteById(id);
	}
	
	public Student getStudentById(long id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public Student updateStudent(long id, Student student) {
	    Optional<Student> studentOptional= studentRepository.findById(id);
		if(studentOptional.isPresent()) {
			Student existingStudent=studentOptional.get();
			existingStudent.setRoll(student.getRoll());
			existingStudent.setName(student.getName());
			existingStudent.setDepartment(student.getDepartment());
			existingStudent.setAddress(student.getAddress());
			existingStudent.setPhone(student.getPhone());
			return studentRepository.save(existingStudent);
		}
		return null;
	}
	
}
