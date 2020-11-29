package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.math.BigDecimal;
import java.util.Collections;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@SpringBootTest
class AnalysisServiceTests {
	
	@Mock EmployeeRepository employeeRepository;
	@InjectMocks AnalysisService analysisService; 
	@Test
	void contextLoads() {
		doReturn(Collections.singletonList(Employee.builder().name("jim").department(Department.builder().name("orc").build()).salary(BigDecimal.TEN).build())).when(employeeRepository).findAll();
		SummaryStatistics summaryStatistics = analysisService.getSummaryStatistics();
		assertEquals(10.0, summaryStatistics.getMin());
	}

}
