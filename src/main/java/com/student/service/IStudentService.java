package com.student.service;

import java.util.List;
import java.util.Optional;

import com.student.entity.Response;
import com.student.entity.Students;
import com.student.entity.StudentsRequest;

public interface IStudentService {

	public Response addStudent(StudentsRequest student);
	
	public Response updateById(Students student);
	
	public Response deleteById(Integer studentId);
	
	public List<Students> findAll();
	
	public Optional<Students> findById(Integer studentId);
	
	public Integer getStudentCountByTeacher(Integer teacherId);
}
