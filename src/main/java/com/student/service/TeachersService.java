package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.TeachersDao;
import com.student.entity.Response;
import com.student.entity.Teacher;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TeachersService implements ITeachersService {

	@Autowired
	TeachersDao teachersDao;

	@Autowired
	Response response;

	@Override
	public Response addTeacher(Teacher teacher) {
		try {
			Teacher result = teachersDao.save(teacher);
			log.info("Add student Result {}", result);

			response.setStatus(200);
			response.setMessage("student record added");
		} catch (Exception e) {
			log.error("Error raised in student service {}", e.getMessage());
			response.setStatus(400);
			response.setMessage("failed to add student record");
		}
		return response;
	}

	@Override
	public Response deleteById(Integer teacherId) {
		try {
			teachersDao.deleteById(teacherId);
			response.setMessage("record deleted");
			response.setStatus(200);
		} catch (Exception e) {
			log.error("error raised deleteById {}", e.getMessage());
			response.setMessage("Internal server error");
			response.setStatus(500);
		}
		return response;
	}

	@Override
	public List<Teacher>  getAllTeachers() {
		List<Teacher> stud = null;
		try {
			stud = teachersDao.findAll();
		} catch (Exception e) {
			log.error("error raised findAll {}", e.getMessage());
		}
		return stud;
	}

	@Override
	public Teacher getTeacher(Integer teacherId) {
		Teacher stud = null;
		try {
			stud = teachersDao.findById(teacherId).get();
		} catch (Exception e) {
			log.error("error raised findByIdl {}", e.getMessage());
		}
		return stud;
	}

}
