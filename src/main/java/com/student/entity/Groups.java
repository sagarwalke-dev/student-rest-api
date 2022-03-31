package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "TBL_GROUPS")
@Data
public class Groups {
	
	@Id
	@Column(name = "group_id")
	private Integer groupId;

	@Column(name = "name")
	private String name;
}
