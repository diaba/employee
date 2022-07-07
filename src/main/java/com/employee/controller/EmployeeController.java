package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.model.Employee;
import com.employee.model.EmployeePhone;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {
	private EmployeeService employeeService;
	
	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@PostMapping("/api/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.addNewEmployee(employee);
	}
	
	@PutMapping("/api/employee/{employeeId}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable Long employeeId) {
		return employeeService.updateEmployee(employeeId, employee);
	}
	
	@DeleteMapping("/api/employee/{employeeId}")
	public String deleteEmployee( @PathVariable Long employeeId) {
		return employeeService.deleteEmployee(employeeId);
	}
	@PostMapping("/api/employee/{employeeId}")
	public EmployeePhone addEmployeePhone(@RequestBody EmployeePhone phone, @PathVariable Long employeeId) {
		return employeeService.addPhone(phone,employeeId);
	}
}
