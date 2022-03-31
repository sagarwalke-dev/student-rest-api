package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.entity.Response;
import com.student.entity.Students;

public interface IStudentService {

	public Response addStudent(Students student);
	
	public Response updateById(Students student);
	
	public Response deleteById(Integer studentId);
	
	public List<Students> findAll();
	
	public Optional<Students> findById(Integer studentId);
	
	public Integer getStudentCountByTeacher(Integer teacherId);
}
