package com.student.service;

import java.util.List;

public interface IMarksService {

	public Integer getMarks(Integer studentId);
	
	public List<Integer> getMarksList(Integer studentId);
}
