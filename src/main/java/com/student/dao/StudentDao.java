package com.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.entity.Students;
@Repository
public interface StudentDao extends JpaRepository<Students, Integer> {

//	@Query("update TBL_STUDENTS s set s.first_name= :name WHERE s.student_id = :id")
//    void updateById(Integer id,String name);
	
	@Query(value = "select count(student_id) from TBL_STUDENTS where group_id=(select group_id from TBL_TEACHER where teacher_id=?1)",nativeQuery = true)
	public Integer getStudentCountByTeacherId(Integer teacherId);
}
