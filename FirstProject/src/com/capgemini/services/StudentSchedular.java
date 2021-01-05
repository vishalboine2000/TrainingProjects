package com.capgemini.services;
import com.capgemini.beans.*;

public class StudentSchedular {	
	private int counterStudent;
	Student[] student=new Student[5];
	
	public String addStudent(int rollNo, String name , String[] courses) {
		student[counterStudent++]=new Student(rollNo,name,courses);
		return "Student added sucessfully";
	}
	
	public void showallStudent() {
		for(int i=0;i<counterStudent;i++) {
			System.out.println("Roll no is  "+student[i].getRollNum());
			System.out.println("Name is  "+student[i].getName());
			System.out.println("Student Courses are");
			  for(String temp:student[i].getCourses())   //foreach loop or enhanced for loop
	            {
	                System.out.println(temp+" ");
	            }
		}
	}
	
	
	
	public void studentdetailsbyRollno(int rollNumber) {
		
		int flag=0;
		for(int i=0;i<counterStudent;i++) {
			
			if(student[i].getRollNum()== rollNumber) {
				String[] courses =student[i].getCourses();
				System.out.println("Roll no is  "+student[i].getRollNum());
				System.out.println("Name is  "+student[i].getName());
				System.out.println("Courses are"); 
				 for(int j=0;j<courses.length;j++) {
					 System.out.println(courses[j]+"\t");
				 }
				 flag=1;
				 break;
			}
			
		}
		if(flag==0)
			System.out.println("Roll number does not exist");
	}
	
	public void showByCourse(String courseSearch) 
	{
		if(counterStudent==0)
			System.out.println("No Records Entered");
		else
		{
			for(int i=0;i<counterStudent;i++)
			{
				for(String course:student[i].getCourses()) 
				{
					if(courseSearch.equalsIgnoreCase(course))
					{
						System.out.println("Roll Number: "+student[i].getRollNum() );
						System.out.println("Name: "+student[i].getName());
						System.out.print("Courses Registered: ");
						for(String course1:student[i].getCourses()) 
						{
							System.out.print(course1+" ");
						}
						System.out.println("\n");
					}
				}
			}
		}	
	}
	
	public void countByCourse(String courseSearch)
	{
		if(counterStudent==0)
			System.out.println("No Records Entered");
		else 
		{
			int count=0;
			for(int i=0;i<counterStudent;i++)
			{
				for(String course:student[i].getCourses()) 
				{
					if(courseSearch.equalsIgnoreCase(course))
						count++;
				}
			}
			System.out.println(count +" Students have registered for this course\n");
		}

	}
}
