package com.microservice.department;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.microservice.department.pojo.Employee;

@RestController
public class DepartmentController {
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeProxy employeeProxy;
	

	@GetMapping("/getAllDepartment")
	public List<Department> getAllDepartment() {
		List<Department> departments = departmentRepository.findAll();
		return departments;

	}

	@GetMapping("/getByDepartmentId/{id}")
	public Optional<Department> getByDepartmentId(@PathVariable Long id) {
		Optional<Department> department = departmentRepository.findById(id);
		return department;

	}

	@PutMapping("/updateByDepartmentId/{id}")
	public String updateByDepartmentId(@RequestBody Department department, @PathVariable Long id) {
		if (departmentRepository.findById(id) != null) {
			Department savedDepartment = departmentRepository.save(department);
			return "updated Employee Details";

		} else {
			return "record not found";
		}

	}
	@PostMapping("/addDepartment")
	public Department createEmployee(@RequestBody Department department) {
		
		 Department department1=departmentRepository.save(department);
		return department1;
		
	}

	@DeleteMapping("/deleteByDepartmentId/{id}")
	public String deleteByDepartmentId(@PathVariable Long id) {

		departmentRepository.deleteById(id);
		return " Employee Details deleted";

	}

	/*
	 * @GetMapping("/getEmployeeByDepartmentId/{depid}") public DepartmentPojo
	 * getEmployeeByDepartmentId(@PathVariable long depid) {
	 * 
	 * Optional<Department> departmentoptinal =
	 * departmentRepository.findById(depid);
	 * 
	 * List<Employee> response = employeeProxy.getByEmployeeWithDepartmentId(depid);
	 * 
	 * DepartmentPojo departmentpojo = null; if (departmentoptinal.isPresent()) {
	 * Department department = departmentoptinal.get(); departmentpojo = new
	 * DepartmentPojo();
	 * departmentpojo.setDepartmentid(department.getDepartmentid());
	 * departmentpojo.setDepartmentname(department.getDepartmentname());
	 * departmentpojo.setDepartmentdescription(department.getDepartmentdescription()
	 * ); departmentpojo.setDepartmentlocation(department.getDepartmentlocation());
	 * departmentpojo.setEmployee(response); } return departmentpojo;
	 * 
	 * }
	 */
	
	@GetMapping("/getEmployeeByDepartmentId/{depid}")
	public Optional<Department> getEmployeeByDepartmentId(@PathVariable long depid) {

		Optional<Department> departmentoptinal = departmentRepository.findById(depid);

		List<Employee> response = employeeProxy.getByEmployeeWithDepartmentId(depid);
	
		
		if (departmentoptinal.isPresent()) {
			
			departmentoptinal.get().setEmployeeList(response);
			
		}
		return departmentoptinal;

	}
	

}
