package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TBL_STUDENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
	
	@Id
	@Column(name = "student_id")
	private Integer studentId;

	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "group_id")
	private Integer groupId;

}
