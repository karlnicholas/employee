package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.HRService;

@RestController
@RequestMapping("hr")
public class HRController {
	private final HRService hrService;
	public HRController(HRService hrService) {
		this.hrService = hrService;
	}
	
	@GetMapping("employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return ResponseEntity.ok(hrService.getEmployees());
	}

}
