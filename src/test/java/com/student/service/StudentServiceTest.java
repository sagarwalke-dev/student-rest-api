package com.student.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.student.dao.StudentDao;
import com.student.entity.Response;
import com.student.entity.Students;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig
class StudentServiceTest {

	@Mock
	private StudentDao studentDao;
	
	@Mock
	private StudentService studentService;
	@Test
	void testAddStudent() {
		Students student=new Students();
		Response response=new Response();
		Mockito.when(studentDao.save(Mockito.any())).thenReturn(student);
		Mockito.when(studentService.addStudent(Mockito.any())).thenReturn(response);
		Response actual = studentService.addStudent(Mockito.any());
		assertEquals(response,actual);
	}
	
	@Test
	void testGetStudentCountByTeacher() {
		Integer result=new Integer(0);
		Mockito.when(studentDao.getStudentCountByTeacherId(Mockito.anyInt())).thenReturn(result);
		Integer actual = studentService.getStudentCountByTeacher(Mockito.anyInt());
		assertEquals(result,actual);
	}

}
