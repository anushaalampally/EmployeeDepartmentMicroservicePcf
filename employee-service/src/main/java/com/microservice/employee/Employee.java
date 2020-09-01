
package com.microservice.employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class Employee {

	@Id
	private Long employeeid;

	@Column
	private String firstname;

	@Column
	private String lastname;

	@Column
	private String companyemail;

	@Column
	private String role;

	@Column
	private Long departmentid;
	
	/*
	 * public Long getEmployeeid() { return employeeid; }
	 * 
	 * public void setEmployeeid(Long employeeid) { this.employeeid = employeeid; }
	 * 
	 * public String getFirstname() { return firstname; }
	 * 
	 * public void setFirstname(String firstname) { this.firstname = firstname; }
	 * 
	 * public String getLastname() { return lastname; }
	 * 
	 * public void setLastname(String lastname) { this.lastname = lastname; }
	 * 
	 * public String getCompanyemail() { return companyemail; }
	 * 
	 * public void setCompanyemail(String companyemail) { this.companyemail =
	 * companyemail; }
	 * 
	 * public String getRole() { return role; }
	 * 
	 * public void setRole(String role) { this.role = role; }
	 * 
	 * public Long getDepartmentid() { return departmentid; }
	 * 
	 * public void setDepartmentid(Long departmentid) { this.departmentid =
	 * departmentid; }
	 * 
	 * 
	 */
}
