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

import com.example.demo.model.Teacher;
import com.example.demo.service.TeacherService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/apit")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TeacherController {

	@Autowired
	private final TeacherService teacherService;
	
	@PostMapping("/teacher")
	public Teacher postTeacher(@RequestBody Teacher teacher) {
		return teacherService.postTeacher(teacher);
	}
	
	@GetMapping("/teachers")
	public List<Teacher> getAllTeacher(){
		return teacherService.getAllTeacher();
	}
	
	@DeleteMapping("/teacher/{id}")
	public void deleteTeacher(@PathVariable long id) {
		teacherService.deleteTeacher(id);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Teacher> getStudentById(@PathVariable long id) {
		Teacher teacher = teacherService.getTeacherById(id);
		if(teacher==null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(teacher);
				
	}
	
	@PutMapping("/teacher/{id}")
	public ResponseEntity<Teacher> updateTeacher(@PathVariable long id,@RequestBody Teacher teacher){
		Teacher updatedTeacher = teacherService.updateTeacher(id, teacher);
		if(updatedTeacher==null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(updatedTeacher);
	}
}
