package com.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.Teacher;
@Repository
public interface TeachersDao extends JpaRepository<Teacher, Integer> {

}
