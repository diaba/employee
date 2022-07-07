package com.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exception.NotFoundException;
import com.employee.model.Employee;
import com.employee.model.EmployeePhone;
import com.employee.repository.EmployeePhoneRepository;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	private EmployeeRepository employeeRepository;
    private EmployeePhoneRepository employeePhoneRepository;
	@Autowired
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	

	@Autowired
	public void setEmployeeRepository(EmployeePhoneRepository employeePhoneRepository) {
		this.employeePhoneRepository = employeePhoneRepository;
	}

	public Employee addNewEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	public Employee updateEmployee(Long empId, Employee emp) {
		Optional<Employee> empFound = employeeRepository.findById(empId);

		if (empFound.isEmpty()) {
			// no employee found
			throw new NotFoundException("Employee with id " + empId + " was not found!");
		}
		empFound.get().setAddress(emp.getAddress());
		empFound.get().setName(emp.getName());
		return employeeRepository.save(empFound.get());

	}

	public String deleteEmployee(Long empId) {
		Optional<Employee> empFound = employeeRepository.findById(empId);

		if (empFound.isEmpty()) {
			// no employee found
			throw new NotFoundException("Employee with id " + empId + " was not found!");
		}
		employeeRepository.delete(empFound.get());
		return "Employee deleted successfully !";
	}
	
	// Employee phone management
	public EmployeePhone addPhone(EmployeePhone empPhone, Long EmployeeId) {
		Optional<Employee> empFound = employeeRepository.findById(EmployeeId);

		if (empFound.isEmpty()) {
			// no employee found
			throw new NotFoundException("Employee with id " + EmployeeId + " was not found!");
		}		
	
		empPhone.setEmployee(empFound.get());
		return employeePhoneRepository.save(empPhone);
 
	}

}
