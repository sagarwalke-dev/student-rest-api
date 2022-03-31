package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.MarksDao;
import java.util.Collections;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MarksService implements IMarksService {

	@Autowired
	MarksDao marksDao;

	@Override
	public Integer getMarks(Integer studentId) {
		try {
			return marksDao.getMarks(studentId);
		} catch (Exception e) {
			log.error("error raised getMarks {}", e.getMessage());
			return null;
		}
	}

	@Override
	public List<Integer> getMarksList(Integer studentId) {
		try {
			return marksDao.getMarksList(studentId);
		} catch (Exception e) {
			log.error("error raised getMarksList {}", e.getMessage());
			return Collections.emptyList();
		}
	}

}
