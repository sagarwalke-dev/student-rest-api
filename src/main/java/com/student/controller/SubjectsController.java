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
import com.student.entity.Subjects;
import com.student.service.ISubjectsService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/subjects")
@SecurityRequirement(name = "studentapi")
@Slf4j
public class SubjectsController {

	
	@Autowired
	ISubjectsService subjectsService;

	@Autowired
	Response response;
	@PostMapping("/add")
	public Response add(@RequestBody Subjects subject) {
		
		try {
			response= subjectsService .addSubject(subject);
		} catch (Exception e) {
			log.info("Error raised on add controller {}", e.getMessage());
		}
		return response;
	}
	
	@GetMapping("/getAll")
	public List<Subjects> getAll() {
		try {
			return subjectsService.getAllSubject();
		} catch (Exception e) {
			log.info("Error raised on  controller  {}", e.getMessage());
			return Collections.emptyList();
		}
	}
	
	@GetMapping("/getById")
	public Subjects getById(@RequestParam Integer subjectId) {
		try {
			return subjectsService.getSubject(subjectId);
		} catch (Exception e) {
			log.info("Error raised on marks controller getAllMarks {}", e.getMessage());
			return (Subjects) Collections.emptyList();
		}
	}

	@GetMapping("/deleteById")
	public Response deleteById(@RequestParam Integer subjectId) {
		try {
			return subjectsService.deleteById(subjectId);
		} catch (Exception e) {
			log.info("Error raised on marks controller deleteById {}", e.getMessage());
			return null;
		}
	}
}
