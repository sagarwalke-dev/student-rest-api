package com.student.service;

import java.util.List;

import com.student.entity.Groups;
import com.student.entity.Response;

public interface IGroupsService {

	public Response addGroup(Groups group);
	public Groups getGroup(Integer groupId);
	public Response deleteById(Integer groupId);
	public List<Groups> getAllGroup();
}
