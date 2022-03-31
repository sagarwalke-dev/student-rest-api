package com.student.service;

import java.util.List;

import com.student.entity.Response;
import com.student.entity.Subjects;

public interface ISubjectsService {

	public Response addSubject(Subjects subjects);
	public Subjects getSubject(Integer subjectId);
	public Response deleteById(Integer subjectId);
	public List<Subjects> getAllSubject();
}
