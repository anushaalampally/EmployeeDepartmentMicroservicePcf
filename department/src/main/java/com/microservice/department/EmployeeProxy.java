package com.microservice.department;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.department.pojo.Employee;

@FeignClient(name="employee-service",url="${EMPLOYEE_SERVICE_URI:http://localhost:8000}")
//@FeignClient(name="employee-service")
//@FeignClient(name="netflix-zuul-api-gateway-server")
//@RibbonClient(name="employee-service")
public interface EmployeeProxy {
	//@GetMapping("/employee-service/getByEmployeeWithDepartmentId/{departmentid}")
	@GetMapping("/getByEmployeeWithDepartmentId/{departmentid}")
	public List<Employee> getByEmployeeWithDepartmentId(@PathVariable("departmentid") long departmentid);
}
