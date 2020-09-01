package com.microservice.employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	List<Employee> findBydepartmentid(long departmentid);
}
