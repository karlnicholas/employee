package com.example.demo.service;

import org.apache.commons.math3.stat.descriptive.SummaryStatistics;
import org.springframework.stereotype.Service;

import com.example.demo.repository.EmployeeRepository;

@Service
public class AnalysisService {
	private final EmployeeRepository employeeRepository;
	public AnalysisService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	public SummaryStatistics getSummaryStatistics() {
		SummaryStatistics summaryStatistics = new SummaryStatistics();
		employeeRepository.findAll().stream().mapToDouble(e->e.getSalary().doubleValue()).forEach(summaryStatistics::addValue);
		return summaryStatistics;
	}
}
