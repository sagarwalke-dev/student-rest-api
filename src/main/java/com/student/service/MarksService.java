package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.MarksDao;
import com.student.entity.Marks;
import com.student.entity.Response;
import com.student.entity.Students;

import java.util.Collections;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MarksService implements IMarksService {

	@Autowired
	MarksDao marksDao;

	@Autowired
	Response response;

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

	@Override
	public Response addMark(Marks marks) {
		try {
			Marks result = marksDao.save(marks);
			log.info("Add student Result {}", result);

			response.setStatus(200);
			response.setMessage("marks record added");

		} catch (Exception e) {
			log.error("Error raised in marks service {}", e.getMessage());
			response.setStatus(400);
			response.setMessage("failed to add marks record");
		}
		return response;
	}

	@Override
	public Response deleteById(Integer markId) {
		try {
			marksDao.deleteById(markId);
			response.setMessage("marks record deleted");
			response.setStatus(200);
		} catch (Exception e) {
			log.error("error raised deleteById marks {}", e.getMessage());
			response.setMessage("Internal server error");
			response.setStatus(500);
		}
		return response;
	}

	@Override
	public List<Marks> findAll() {
		List<Marks> marksList = null;
		try {
			marksList = marksDao.findAll();
		} catch (Exception e) {
			log.error("error raised findAll marks {}", e.getMessage());
		}
		return marksList;
	}

}
