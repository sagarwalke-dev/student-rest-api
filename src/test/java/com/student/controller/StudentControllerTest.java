package com.student.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.student.entity.Response;
import com.student.entity.Students;
import com.student.service.StudentService;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = StudentController.class)
class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private StudentService studentService;

	@Test
	void testAddStudent() throws Exception {
		Response response=new Response();
		Students student=new Students();
		response.setStatus(200);
		response.setMessage(Mockito.anyString());
		Mockito.when(studentService.addStudent(Mockito.any())).thenReturn(response);
		mockMvc.perform(post("/addStudent").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}

}
