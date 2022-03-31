package com.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.entity.Subjects;

@Repository
public interface SubjectsDao extends JpaRepository<Subjects, Integer> {

}
