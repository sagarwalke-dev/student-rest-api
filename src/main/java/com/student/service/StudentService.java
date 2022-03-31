package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.StudentDao;
import com.student.entity.Response;
import com.student.entity.Students;

import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.asm.Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName;

@Service
@Slf4j
public class StudentService implements IStudentService {

	@Autowired
	StudentDao studentDao;

	@Autowired
	Response response;

	@Override
	public Response addStudent(Students student) {
		try {
			Students result = studentDao.save(student);
			log.info("Add student Result {}", result);
			if (result != null) {
				response.setStatus(200);
				response.setMessage("student record added");
			} else {
				response.setStatus(400);
				response.setMessage("failed to add student record");
			}
		} catch (Exception e) {
			log.error("Error raised in student service {}", e.getMessage());
			response.setStatus(500);
			response.setMessage("internal server error");
		}
		return response;
	}

	@Override
	public Response updateById(Students student) {
		try {

		} catch (Exception e) {

		}
		return null;
	}

	@Override
	public Response deleteById(Integer studentId) {
		try {
			studentDao.deleteById(studentId);
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
	public List<Students> findAll() {
		List<Students> stud = null;
		try {
			stud = studentDao.findAll();
		} catch (Exception e) {
			log.error("error raised findAll {}", e.getMessage());
		}
		return stud;
	}

	@Override
	public Optional<Students> findById(Integer studentId) {
		Optional<Students> stud = null;
		try {
			stud = studentDao.findById(studentId);
		} catch (Exception e) {
			log.error("error raised findByIdl {}", e.getMessage());
		}
		return stud;
	}

	@Override
	public Integer getStudentCountByTeacher(Integer teacherId) {
		try {
			return studentDao.getStudentCountByTeacherId(teacherId);
		} catch (Exception e) {
			log.error("error raised getStudentCountByTeacher {}", e.getMessage());
			return null;
		}
		
	}

}
