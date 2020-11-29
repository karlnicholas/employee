package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@SpringBootTest
class HRServiceTests {

	
	@Mock EmployeeRepository employeeRepository;
	@InjectMocks HRService hrService; 
	@Test
	void contextLoads() {
		doReturn(Collections.singletonList(Employee.builder().name("jim").department(Department.builder().name("orc").build()).build())).when(employeeRepository).findAll();
		List<Employee> employees = hrService.getEmployees();
		System.out.println(employees);
		assertEquals("jim", employees.get(0).getName());
	}

}
