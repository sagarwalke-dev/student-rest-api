package com.student.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Response;
import com.student.entity.Teacher;
import com.student.service.ITeachersService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/teacher")
@SecurityRequirement(name = "studentapi")
@Slf4j
public class TeachersController {

	
	@Autowired
	ITeachersService teachersService;

	@Autowired
	Response response;
	@PostMapping("/add")
	public Response add(@RequestBody Teacher teacher) {
		
		try {
			response= teachersService .addTeacher(teacher);
		} catch (Exception e) {
			log.info("Error raised on add controller {}", e.getMessage());
		}
		return response;
	}
	
	@GetMapping("/getAll")
	public List<Teacher> getAll() {
		try {
			return teachersService.getAllTeachers();
		} catch (Exception e) {
			log.info("Error raised on  controller  {}", e.getMessage());
			return Collections.emptyList();
		}
	}
	
	@GetMapping("/getById")
	public Teacher getById(@RequestParam Integer teacherId) {
		try {
			return teachersService.getTeacher(teacherId);
		} catch (Exception e) {
			log.info("Error raised on marks controller getAllMarks {}", e.getMessage());
			return (Teacher) Collections.emptyList();
		}
	}

	@GetMapping("/deleteById")
	public Response deleteById(@RequestParam Integer teacherId) {
		try {
			return teachersService.deleteById(teacherId);
		} catch (Exception e) {
			log.info("Error raised on marks controller deleteById {}", e.getMessage());
			return null;
		}
	}
}
