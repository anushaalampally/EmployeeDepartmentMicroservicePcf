package com.microservice.employee;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	private Environment environment;
	
@GetMapping("/getAllEmployee")
public List<Employee> getAllemployee() {
	List<Employee> employees=employeeRepository.findAll();
	return employees;
	
}
@GetMapping("/getByEmployeeId/{id}")
public Optional<Employee> getByEmployeeId(@PathVariable Long id) {
	
	Optional<Employee> employee=employeeRepository.findById(id);
	return employee;
	
}
@PostMapping("/addEmployee")
public Employee createEmployee(@RequestBody Employee theEmployee) {
	
	 Employee employee=employeeRepository.save(theEmployee);
	return employee;
	
}

@PutMapping("/updateByEmployeeId/{id}")
public String updateByEmployeeId(@RequestBody Employee employee,@PathVariable Long id) {
	if(employeeRepository.findById(id)!=null) {		
		Employee savedEmployee=employeeRepository.save(employee);
		return "updated Employee Details";
		
}else {
	return "record not found";
}
	
}
@DeleteMapping("/deleteByEmployeeId/{id}")
public String deleteByEmployeeId(@PathVariable Long id) {
		
	employeeRepository.deleteById(id);
		return " Employee Details deleted";
		

}


@GetMapping("/getByEmployeeWithDepartmentId/{departmentid}")
public List<Employee> getByEmployeeWithDepartmentId(@PathVariable long departmentid) {

	List<Employee> employee= employeeRepository.findBydepartmentid(departmentid);
	//employee.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
	//System.out.println(environment.getProperty("local.server.port"));
	return employee;
	
}
}
