package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.SubjectsDao;
import com.student.entity.Response;
import com.student.entity.Subjects;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SubjectsService implements ISubjectsService {

	@Autowired
	SubjectsDao subjectDao;

	@Autowired
	Response response;

	@Override
	public Response addSubject(Subjects subject) {
		try {
			subjectDao.save(subject);
			response.setStatus(200);
			response.setMessage("subject record added");
		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage("failed to add subject record");
		}
		return response;
	}

	@Override
	public Subjects getSubject(Integer subjectId) {
		try {
			return subjectDao.findById(subjectId).get();
		} catch (Exception e) {
			return (Subjects) Optional.empty().get();
		}
	}

	@Override
	public List<Subjects> getAllSubject() {
		try {
			return subjectDao.findAll();
		} catch (Exception e) {
			return (List<Subjects>) Optional.empty().get();
		}
	}

	@Override
	public Response deleteById(Integer subjectId) {
		try {
			subjectDao.deleteById(subjectId);
			response.setMessage("subject record deleted");
			response.setStatus(200);
		} catch (Exception e) {
			log.error("error raised deleteById marks {}", e.getMessage());
			response.setMessage("failed to add subject record");
			response.setStatus(500);
		}
		return response;
	}

}
