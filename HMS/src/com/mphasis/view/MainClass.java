package com.mphasis.view;
import java.util.*;
import java.util.function.BiPredicate;
import java.io.*;
//import com.mphasis.model.Employee;
import com.mphasis.controller.EmployeeController;
import com.mphasis.controller.EmployeeInterface;
import com.mphasis.exception.UserNotFoundException;
import com.mphasis.model.Employee;
public class MainClass {
	public static void main(String args[]) throws IOException
	{
		/*Employee emp=new Employee();
		emp.setEid(150);
		emp.setEname("Meghana");
		System.out.println(emp.getEid()+" "+emp.getEname());
		System.out.println(emp);
		Employee emp1=new Employee();*/
		
		/*Scanner sc=new Scanner(System.in);
		System.out.println("Enter no.of employees:");
		int len=sc.nextInt();
		Employee[] err=new Employee[len];
		for(int i=0;i<len;i++)
		{
			System.out.println("Enter Employee id:");
			int eid=sc.nextInt();
			System.out.println("Enter Employee name:");
			String ename=sc.next();
			err[i]=new Employee(eid,ename);		
			
		}
		for(Employee j:err) {
			System.out.println(j);
		}*/
		
		EmployeeInterface ec = new EmployeeController();
		List<Employee> elist=null;
		Scanner sc = new Scanner(System.in);

		String input = null;
		System.out.println("Enter user name:");
		String uname=sc.next();
		System.out.println("Enter password:");
		String pwd=sc.next();
		System.out.println("Loading...");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			//if(uname.equals("meghana")&&pwd.equals("meghana"))
			BiPredicate<String, String> pred = (un,pw)->un.equals("meghana") && pw.equals("password");
			
		    if(pred.test(uname,pwd)) //test is predefined
			
				System.out.println("welcome");
			
			else
				
				throw new UserNotFoundException();
			
			/*catch(UserNotFoundException e) 
			{
				System.out.println(e);
			}*/
	
		do {
			System.out.println("Enter your Choice");
			System.out.println("1.Add Employee");
			System.out.println("2.View Employee");
			System.out.println("3.Add Department");
			System.out.println("4.view Department");
			System.out.println("5.sort Employees");
			System.out.println("6.sort Employees using stream");
			System.out.println("7.Serialize");
			System.out.println("8.Deserialize");
			System.out.println("9.Procedure Insert");
			System.out.println("10.Get ResultSet MetaData Info");
			System.out.println("11.RS Forward Only");
			System.out.println("12.RS scroll insensitive");
			System.out.println("13.RS scroll sensitive - insert");
			System.out.println("14.RS scroll sensitive - update");
			System.out.println("15.Batch update");
			
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				elist=ec.addEmployee();
				break;
			}

			case 2: {
				ec.viewEmployee(elist);
				break;
			}
			case 3: {
					ec.addDept();
					break;
			}
			case 4: {
					ec.viewDept();
					break;
			}
			case 5: {
					ec.sortByName();
					break;
			}
			case 6:{
					ec.sortNameByStream();
					break;
			}
			case 7:{
				ec.serialize();
				break;
			}
			case 8:{
				ec.deserialize();
				break;
			}
			case 9:{
				ec.insertUsingProc();
				break;
			}
			case 10:{
				ec.rsmd();
				break;
			}
			case 11: {
				ec.type_forward_only_rs();
				break;
			}
			case 12: {
				ec.type_scroll_insensitive_rs();
				break;
			}
			case 13: {
				ec.type_scroll_sensitive_rs_insert();
				break;
			}
			case 14: {
				ec.type_scroll_sensitive_rs_update();
				break;
			}
			case 15: {
				ec.batchUpdate();
				break;
			}
			default: {

			}

			}
			System.out.println("Do you want to continue ? Y or y for yes");
			input = sc.next();
		} while (input.equals("Y") || input.equals("y"));
		
		/*System.out.println("System Exited..Thanks for using our system !!!");
		System.exit(0);*/
		}
		catch(UserNotFoundException e) 
		{
			System.out.println(e);
		}
		finally {
			System.out.println("Finally executed");
		}
		System.out.println("System Exited..Thanks for using our system !!!");
		System.exit(0);
		
	}
}
