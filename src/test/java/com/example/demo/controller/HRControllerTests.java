package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.service.HRService;

@WebMvcTest(HRController.class)
class HRControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean HRService hrService;

	@Test
	public void greetingShouldReturnMessageFromService() throws Exception {
		doReturn(Collections.singletonList(Employee.builder().name("Karl").department(Department.builder().name("it").build()).salary(BigDecimal.TEN).build())).when(hrService).getEmployees();
		this.mockMvc.perform(get("/hr/employees")).andDo(print()).andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"id\":null,\"name\":\"Karl\",\"department\":{\"id\":null,\"name\":\"it\"},\"salary\":10}")));
	}
}
