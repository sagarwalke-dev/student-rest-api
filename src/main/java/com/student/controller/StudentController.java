package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Response;
import com.student.entity.Students;
import com.student.service.IMarksService;
import com.student.service.IStudentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.Collections;
import lombok.extern.slf4j.Slf4j;

@RestController(value = "/student")
@SecurityRequirement(name = "studentapi")
@CrossOrigin
@Slf4j
public class StudentController {

	@Autowired
	IStudentService studentService;
	
	@Autowired
	IMarksService marksService;

	@PostMapping("/add")
	public Response addStudent(@RequestBody Students student) {
		try {
			return studentService.addStudent(student);
		} catch (Exception e) {
			log.info("Error raised on student controller {}", e.getMessage());
		}
		return null;
	}

	@GetMapping("/findAll")
	public List<Students> getAllStudents() {
		try {
			return studentService.findAll();
		} catch (Exception e) {
			log.info("Error raised on student controller getAllStudents {}", e.getMessage());
			return Collections.emptyList();
		}
	}

	@GetMapping("/findById")
	public Optional<Students> getStudentById(@RequestParam Integer studentId) {
		try {
			return studentService.findById(studentId);
		} catch (Exception e) {
			log.info("Error raised on student controller getStudentById {}", e.getMessage());
			return Optional.of(new Students());
		}
	}
	
	@GetMapping("/deleteById")
	public Response deleteById(@RequestParam Integer studentId) {
		try {
			return studentService.deleteById(studentId);
		} catch (Exception e) {
			log.info("Error raised on student controller deleteById {}", e.getMessage());
			return null;
		}
	}
	
	@GetMapping("/getMarks")
	public Integer getMarks(@RequestParam Integer studentId) {
		try {
			return marksService.getMarks(studentId);
		} catch (Exception e) {
			log.info("Error raised on student controller getMarks {}", e.getMessage());
			return null;
		}
	}
	
	
	@GetMapping("/getStudentCount")
	public Integer getStudentCountByTeacher(@RequestParam Integer teacherId) {
		try {
			return studentService.getStudentCountByTeacher(teacherId);
		} catch (Exception e) {
			log.info("Error raised on student controller getStudentCountByTeacher {}", e.getMessage());
			return null;
		}
	}
	
	@GetMapping("/getMarksList")
	public List<Integer> getMarksList(@RequestParam Integer studentId) {
		try {
			return marksService.getMarksList(studentId);
		} catch (Exception e) {
			log.info("Error raised on student controller getMarksList {}", e.getMessage());
			return Collections.emptyList();
		}
	}
}
