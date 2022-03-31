package com.student.service;

import java.util.List;

import com.student.entity.Marks;
import com.student.entity.MarksRequest;
import com.student.entity.Response;

public interface IMarksService {

	public Integer getMarks(Integer studentId);
	
	public List<Integer> getMarksList(Integer studentId);
	
	public Response addMark(MarksRequest mark);
	
public Response deleteById(Integer markId);
	
	public List<Marks> findAll();
}
