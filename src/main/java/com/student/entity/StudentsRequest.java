package com.student.entity;

import lombok.Data;

@Data
public class StudentsRequest {
	private Integer studentId;
	private String firstName;
	private String lastName;
	private Integer groupId;
}
