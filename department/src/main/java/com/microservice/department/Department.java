
package com.microservice.department;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.microservice.department.pojo.Employee;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {

	@Id
	
	private Long departmentid;
	@Column
	
	private String departmentname;
	@Column
	
	private String departmentdescription;
	@Column
	
	private String departmentlocation;
	
	@Transient
	
	private List<Employee> employeeList;
	

	

	/*
	 * public List<Employee> getEmployee() { return employee; } public void
	 * setEmployee(List<Employee> employee) { this.employee = employee; } public
	 * Long getDepartmentid() { return departmentid; } public void
	 * setDepartmentid(Long departmentid) { this.departmentid = departmentid; }
	 * public String getDepartmentname() { return departmentname; } public void
	 * setDepartmentname(String departmentname) { this.departmentname =
	 * departmentname; } public String getDepartmentdescription() { return
	 * departmentdescription; } public void setDepartmentdescription(String
	 * departmentdescription) { this.departmentdescription = departmentdescription;
	 * } public String getDepartmentlocation() { return departmentlocation; } public
	 * void setDepartmentlocation(String departmentlocation) {
	 * this.departmentlocation = departmentlocation; }
	 */

}
