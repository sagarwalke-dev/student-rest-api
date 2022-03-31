package com.student.entity;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Response {
	private Integer status;
	private String message;
}
