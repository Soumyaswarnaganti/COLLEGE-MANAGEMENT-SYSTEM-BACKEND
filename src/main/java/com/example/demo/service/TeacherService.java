package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Teacher;
import com.example.demo.repository.TeacherRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherService {

	@Autowired
	private final TeacherRepository teacherRepository;
	
	public Teacher postTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}
	
	public List<Teacher> getAllTeacher(){
		return teacherRepository.findAll();
	}
	
	public void deleteTeacher(long id) {
		teacherRepository.deleteById(id);
	}
	
	public Teacher getTeacherById(long id) {
		return teacherRepository.findById(id).orElse(null);
	}
	
	public Teacher updateTeacher(long id, Teacher teacher) {
	    Optional<Teacher> teacherOptional= teacherRepository.findById(id);
		if(teacherOptional.isPresent()) {
			Teacher existingTeacher=teacherOptional.get();
			existingTeacher.setName(teacher.getName());
			existingTeacher.setDepartment(teacher.getDepartment());
			existingTeacher.setSubject(teacher.getSubject());
			existingTeacher.setAddress(teacher.getAddress());
			existingTeacher.setPhone(teacher.getPhone());
			return teacherRepository.save(existingTeacher);
		}
		return null;
	}
	
}

