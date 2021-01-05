package com.capgemini.view;
import com.capgemini.services.*;

import java.util.Scanner;

public class Admin {
	private static Scanner sc= new Scanner(System.in);
	private static StudentSchedular studentSchedular=new StudentSchedular();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		menu();
	}
	
	private static void menu() {
		while(true) {
			int choice;
			System.out.println("1.add student");
			System.out.println("2.show all students");
			System.out.println("3.show all student details by roll no");
			System.out.println("4.show student details by course name");
			System.out.println("5.show count by course name");
			System.out.println("6.exit");
			
			System.out.println("Enter your choice");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1: addStudent();
					break;
			case 2: showallStudent();
					break;
			case 3: studentdetailsRollno();
					break;
			case 4: studentdetailsbyCourses();
					break;
			case 5: countByCourse();
					break;
			case 6: System.exit(0);
			
			default:
				System.out.println("Please Enter Valid Choice!");
				
			}
		}
	}
	
	private static void countByCourse() 
	{	
		System.out.println("Enter Course:");
		String courseSearch=sc.next();
		studentSchedular.countByCourse(courseSearch);
	}
	
	private static void studentdetailsbyCourses() 
	{	
		System.out.println("Enter Course:");
		String courseSearch=sc.next();
		studentSchedular.showByCourse(courseSearch);
	}
	private static void studentdetailsRollno()
	{	
		System.out.println("Enter the roll number for student details: ");
		int rollNumber=sc.nextInt();
		studentSchedular.studentdetailsbyRollno(rollNumber);
	}
	private static void showallStudent() {
		studentSchedular.showallStudent();
	}
	private static void addStudent() {
		
		int rollNo,ncourse;
		String name;
		System.out.println("Enter Student Roll No");
		rollNo=sc.nextInt();
		System.out.println("Enter Student Name");
		name=sc.next();
		System.out.println("Enter no. of courses");
		ncourse=sc.nextInt();
		System.out.println("Enter name of the courses");
		String[] studCourses=new String[ncourse];
		for(int i=0;i<ncourse;i++) {
			studCourses[i]=sc.next();
		}
		
		System.out.println(studentSchedular.addStudent(rollNo, name,studCourses));
	}
	

}

