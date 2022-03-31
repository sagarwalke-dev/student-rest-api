package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "TBL_SUBJECT")
@Data
public class Subjects {
	
	@Id
	@Column(name = "subject_id")
	private Integer subjectId;

	@Column(name = "title")
	private String title;
}
