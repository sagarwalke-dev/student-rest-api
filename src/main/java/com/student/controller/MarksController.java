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

import com.student.entity.Marks;
import com.student.entity.Response;
import com.student.entity.Students;
import com.student.service.IMarksService;
import com.student.service.IStudentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.Collections;
import lombok.extern.slf4j.Slf4j;

@RestController(value = "/marks")
@SecurityRequirement(name = "studentapi")
@Slf4j
public class MarksController {

	
	@Autowired
	IMarksService marksService;

	@PostMapping("/addMarks")
	public Response addMarks(@RequestBody Marks mark) {
		try {
			return marksService .addMark(mark);
		} catch (Exception e) {
			log.info("Error raised on addMarks controller {}", e.getMessage());
		}
		return null;
	}
	
	@GetMapping("/getAllMarksList")
	public List<Integer> getMarksList(@RequestParam Integer studentId) {
		try {
			return marksService.getMarksList(studentId);
		} catch (Exception e) {
			log.info("Error raised on marks controller getMarksList {}", e.getMessage());
			return Collections.emptyList();
		}
	}
	
	@GetMapping("/findAllMarks")
	public List<Marks> getAllMarks() {
		try {
			return marksService.findAll();
		} catch (Exception e) {
			log.info("Error raised on marks controller getAllMarks {}", e.getMessage());
			return Collections.emptyList();
		}
	}

	@GetMapping("/deleteMarksById")
	public Response deleteMarksById(@RequestParam Integer markId) {
		try {
			return marksService.deleteById(markId);
		} catch (Exception e) {
			log.info("Error raised on marks controller deleteById {}", e.getMessage());
			return null;
		}
	}
}
