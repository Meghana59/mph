package com.mphasis.controller;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import com.mphasis.dao.EmployeeDao;
import com.mphasis.model.Employee;
import com.mphasis.model.Salary;
//import com.mphasis.sortrg.Student;
import com.mphasis.model.Manager;
public class EmployeeController implements EmployeeInterface{
	Employee emp;
	Salary sal;
	Manager department;
	List<Employee> emplist=new ArrayList<Employee>();
	EmployeeDao empdao=new EmployeeDao();
	public List addEmployee()
	{
		emp = new Employee();
		Scanner  sc = new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno = sc.nextInt();
		emp.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam = sc.next();
		emp.setEname(enam);
		
		sal= new Salary();
		
		System.out.println("Enter basic Salary");
		int basic = sc.nextInt();
		sal.setBasic(basic);
		System.out.println("Enter DA");
		int da = sc.nextInt();
		sal.setDa(da);
		System.out.println("Enter HRA");
		int hra = sc.nextInt();
		sal.setHra(hra);
		System.out.println("Enter PF");
		int pf= sc.nextInt();
		sal.setPf(pf);
		
		sal.setGross(basic, da, hra);
		sal.setNet(sal.getGross(),pf);
		emp.setSalary(sal);
		
		//emplist.add(emp);
		empdao.insertEmp(emp);
		
		//System.out.println(emp.getEid() + " " + emp.getEname());	
		System.out.println("Employee "  + eno + "Succesfully added");
		return emplist;
	}
	
	public void viewEmployee(List elist)
	{
		/*Iterator i=elist.iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}*/
		empdao.viewEmp();
	}
	
	public void insertUsingProc()
	{
		Employee e = new Employee();
		Scanner  sc = new Scanner(System.in);
		System.out.println("Enter the Eid");
		int eno = sc.nextInt();
		e.setEid(eno);
		System.out.println("Enter the Ename ");
		String enam = sc.next();
		e.setEname(enam);
		
		empdao.insertUsingProcedure(e);
	}
	
	public void rsmd() {
		empdao.rsmd();
	}
	
	@Override
	public void type_forward_only_rs() {
		empdao.type_forward_only_rs();
		
	}

	@Override
	public void type_scroll_insensitive_rs() {
		empdao.type_scroll_insensitive_rs();
		
	}

	@Override
	public void type_scroll_sensitive_rs_insert() {
		empdao.type_scroll_sensitive_rs_insert();
		
	}
	
	@Override
	public void type_scroll_sensitive_rs_update() {
		empdao.type_scroll_sensitive_rs_update();
		
	}

	@Override
	public void batchUpdate() {
		empdao.batchUpdate();
		
	}
	
	public void addDept() {
		department=new Manager();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the department");
		String dept=sc.next();
		department.setDept(dept);
		System.out.println("Departmemt"+department+" successfully added");
		
		
	}
	public void viewDept() {
		System.out.println(department);
	}
	/*public void sortByName(List emplist) {
		Collections.sort(emplist,Employee.nameComparator);
		Iterator i=emplist.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}*/

	@Override
	public void sortByName() {
		// TODO Auto-generated method stub
		Collections.sort(emplist,Employee.nameComparator);
		/*Iterator i=emplist.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());*/
		emplist.forEach(lis->System.out.println(lis));	
		
		}
	
	

	@Override
	public void sortNameByStream() {
		// TODO Auto-generated method stub
		Predicate<Employee> em=emp->(emp.getEname().startsWith("A") || emp.getEname().startsWith("a"));
		emplist.stream().filter(em).sorted(Comparator.comparing(Employee::getEname))
		.forEach(System.out::println);
		//emp1.getSalary()>50000 && emp1.getSalary()<95000
	}
	
	public void deserialize(){
		Employee st=null;
		try (FileInputStream fis = new FileInputStream("myfile.txt");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			st =(Employee)ois.readObject();
			fis.close();
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//System.out.println(st.getEid());
	//System.out.println(st.getEname());
	//System.out.println(st.getSalary());
		System.out.println(emp);
	}

	

	public void serialize() {
		// TODO Auto-generated method stub
		Employee ep=new Employee();
		FileOutputStream fos =null ;
		ObjectOutputStream oos =null;
		try {
			fos= new FileOutputStream("myfile.txt");
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ep);
			
			System.out.println("Data successfully Serialized...");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				fos.close();
				oos.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
	}
	
	
	}

