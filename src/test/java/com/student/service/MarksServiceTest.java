package com.student.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.student.dao.MarksDao;

@ExtendWith(SpringExtension.class)
@SpringJUnitConfig
class MarksServiceTest {

	@Mock
	MarksDao marksDao;
	
	@Mock
	MarksService marksService;
	
	@Test
	void testGetMarks() {
		Integer studentId = 0;
		Mockito.when(marksDao.getMarks(Mockito.anyInt())).thenReturn(studentId);
		Integer actual = marksService.getMarks(Mockito.anyInt());
		assertEquals(studentId, actual);
	}

	@Test
	void testGetMarksList() {
		List<Integer> studentId = new ArrayList<Integer>();
		Mockito.when(marksDao.getMarksList(Mockito.anyInt())).thenReturn(studentId);
		List<Integer> actual = marksService.getMarksList(Mockito.anyInt());
		assertEquals(studentId, actual);
	}

}
