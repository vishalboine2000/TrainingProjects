package com.cg.JPAEntity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int departmentId;
	private String departmentName;
	@OneToMany(mappedBy="department",cascade=CascadeType.ALL)
	private Set <Employee> employee = new HashSet<Employee>();

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Set<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(Set<Employee> employee) {
		this.employee = employee;
	}

	public Department() {
		super();
	}
	public void add(Employee employee)
	{
		employee.setDepartment(this);
		this.getEmployee().add(employee);
	}

}