package com.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Groups;
import com.student.entity.Marks;
import com.student.entity.MarksRequest;
import com.student.entity.Response;
import com.student.entity.Students;
import com.student.service.IGroupsService;
import com.student.service.IMarksService;
import com.student.service.IStudentService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.Collections;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/groups")
@SecurityRequirement(name = "studentapi")
@Slf4j
public class GroupsController {

	
	@Autowired
	IGroupsService groupService;

	@Autowired
	Response response;
	@PostMapping("/add")
	public Response add(@RequestBody Groups group) {
		
		try {
			response= groupService .addGroup(group);
		} catch (Exception e) {
			log.info("Error raised on add controller {}", e.getMessage());
		}
		return response;
	}
	
	@GetMapping("/getAll")
	public List<Groups> getAll() {
		try {
			return groupService.getAllGroup();
		} catch (Exception e) {
			log.info("Error raised on  controller  {}", e.getMessage());
			return Collections.emptyList();
		}
	}
	
	@GetMapping("/getById")
	public Groups getById(@RequestParam Integer groupId) {
		try {
			return groupService.getGroup(groupId);
		} catch (Exception e) {
			log.info("Error raised on marks controller getAllMarks {}", e.getMessage());
			return (Groups) Collections.emptyList();
		}
	}

	@GetMapping("/deleteById")
	public Response deleteById(@RequestParam Integer groupId) {
		try {
			return groupService.deleteById(groupId);
		} catch (Exception e) {
			log.info("Error raised on marks controller deleteById {}", e.getMessage());
			return null;
		}
	}
}
