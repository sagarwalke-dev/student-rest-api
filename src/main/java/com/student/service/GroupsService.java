package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dao.GroupsDao;
import com.student.entity.Groups;
import com.student.entity.Response;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GroupsService implements IGroupsService {

	@Autowired
	GroupsDao groupDao;

	@Autowired
	Response response;

	@Override
	public Response addGroup(Groups group) {
		try {
			groupDao.save(group);
			response.setStatus(200);
			response.setMessage("group record added");
		} catch (Exception e) {
			response.setStatus(500);
			response.setMessage("failed to add group");
		}
		return response;
	}

	@Override
	public Groups getGroup(Integer groupId) {
		try {
			return groupDao.findById(groupId).get();
		} catch (Exception e) {
			return (Groups) Optional.empty().get();
		}
	}

	@Override
	public List<Groups> getAllGroup() {
		try {
			return groupDao.findAll();
		} catch (Exception e) {
			return (List<Groups>) Optional.empty().get();
		}
	}

	@Override
	public Response deleteById(Integer groupId) {
		try {
			groupDao.deleteById(groupId);
			response.setMessage("group record deleted");
			response.setStatus(200);
		} catch (Exception e) {
			log.error("error raised deleteById marks {}", e.getMessage());
			response.setMessage("failed to add group record");
			response.setStatus(500);
		}
		return response;
	}

}
