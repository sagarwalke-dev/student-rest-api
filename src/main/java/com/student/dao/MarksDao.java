package com.student.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.entity.Marks;
@Repository
public interface MarksDao extends JpaRepository<Marks, Integer> {

	@Query(value = "SELECT mark FROM TBL_MARKS where student_id = ?1", nativeQuery = true)
	public Integer getMarks(Integer studentId);
	
	@Query(value = "select mark from TBL_MARKS where student_id=?1 group by mark", nativeQuery = true)
	public List<Integer> getMarksList(Integer studentId);
}
