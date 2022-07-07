package com.employee.model;

import java.util.List;

import javax.persistence.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "employees")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private String name;

	@Column
	private String address;

	// Each employee has one to many phones
	@OneToMany(mappedBy = "employee", orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<EmployeePhone> employeePhoneList;

// Getter and setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<EmployeePhone> getEmployeePhoneList() {
		return employeePhoneList;
	}

	public void setEmployeePhoneList(List<EmployeePhone> employeePhoneList) {
		this.employeePhoneList = employeePhoneList;
	}

	// Display
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", employeePhoneList="
				+ employeePhoneList + "]";
	}

// Constructor
	public Employee() {}
		
}
