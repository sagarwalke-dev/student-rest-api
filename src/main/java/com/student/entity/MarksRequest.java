package com.student.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class MarksRequest {
	private Integer markId;
	private Integer mark;
	private Integer studentId;
	private Integer subjectId;
	private Date date;
}
