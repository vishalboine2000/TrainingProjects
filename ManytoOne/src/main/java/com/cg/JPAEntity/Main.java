package com.cg.JPAEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
	public static void main(String [] args)
	{

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("test3");
		EntityManager em = emf.createEntityManager();
		// EntityTransaction transaction = em.getTransaction();
		em.getTransaction().begin();
		Department department = new Department();
		department.setDepartmentName("Marketing");
		Employee employee = new Employee();
		employee.setEmployeeName("vishal");

		Employee employee1 = new Employee();
		employee1.setEmployeeName("mayank");

		Set <Employee> set1 = new HashSet<Employee>();
		set1.add(employee);
		set1.add(employee1);
		department.add(employee);
		department.add(employee1);
		em.persist(department);


		em.getTransaction().commit();
		
		Query query = em.createQuery("select employeeName from Employee e" );
		@SuppressWarnings("unchecked")
		List<String> list = query.getResultList();
		System.out.println(" Employee Name ");
		for(String s : list)
		{
		System.out.println(s);
		}

		Query namedquery= em.createNamedQuery("Employee.findEmployee");
		namedquery.setParameter("id", Long.valueOf(5));
		// namedquery.setParameter("id", 2);
		Employee list1 = (Employee) namedquery.getSingleResult();

		System.out.println(list1.getEmployeeName());
		em.close();
	}
}
