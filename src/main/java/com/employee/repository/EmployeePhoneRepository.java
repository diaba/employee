package com.employee.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeePhone;

@Repository
public interface EmployeePhoneRepository extends JpaRepository<EmployeePhone, Long>{

}
