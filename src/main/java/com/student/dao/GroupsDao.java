package com.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.Groups;

@Repository
public interface GroupsDao extends JpaRepository<Groups, Integer> {

}
