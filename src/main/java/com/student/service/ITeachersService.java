package com.student.service;

import java.util.List;

import com.student.entity.Marks;
import com.student.entity.MarksRequest;
import com.student.entity.Response;
import com.student.entity.Subjects;
import com.student.entity.Teacher;

public interface ITeachersService {

	public Response addTeacher(Teacher teacher);
	public Teacher getTeacher(Integer teacherId);
	public Response deleteById(Integer teacherId);
	public List<Teacher> getAllTeachers();
}
