package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class HRService {
	private final EmployeeRepository employeeRepository;
	public HRService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	public List<Employee>getEmployees() {
		return employeeRepository.findAll();
	}
}
