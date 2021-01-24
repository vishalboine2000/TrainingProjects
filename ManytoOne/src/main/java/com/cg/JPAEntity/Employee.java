package com.cg.JPAEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
@NamedQuery(name = "Employee.findEmployee" , query = "Select e from Employee e where e.employeeId=:id")
public class Employee {
	@Id
	@GeneratedValue
	private int employeeId;
	@Column(name="ename")
	private String employeeName;
	@ManyToOne
	@JoinColumn(name="dept_id_fk")
	private Department department;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
