package com.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.employee.model.Employee;

import javax.persistence.*;

@SuppressWarnings("unused")
@Entity
@Table(name = "employeePhone")
public class EmployeePhone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String phoneNumber;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	@JsonIgnore
	private Employee employee;

	// Getter and Setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	// Display
	@Override
	public String toString() {
		return "EmployeePhone [id=" + id + ", phoneNumber=" + phoneNumber + ", employee=" + employee + "]";
	}

	// Constructor
	public EmployeePhone(String phoneNumber) {
		this.phoneNumber = phoneNumber;	
	}

	public EmployeePhone() {
	}

}
