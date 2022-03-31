package com.student.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TBL_MARKS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Marks {
	
	@Id
	@Column(name = "mark_id")
	private Integer markId;

	@Column(name = "mark")
	private Integer mark;
	
	@Column(name = "student_id")
	private Integer studentId;
	
	@Column(name = "subject_id")
	private Integer subjectId;
	
	@Column(name = "date")
	private Date date;
	
}
