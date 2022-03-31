package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "TBL_TEACHER")
@Data
public class Teacher {
	
	@Id
	@Column(name = "teacher_id")
	private Integer teacherId;

	@Column(name = "subject_id")
	private Integer subjectId;
	
	@Column(name = "group_id")
	private Integer groupId;
}
