package com.mphasis.model;

import java.io.Serializable;
import java.util.Comparator;

public class Employee implements Serializable{
	private int eid;
	private String ename;
	private Salary salary;
	public Employee() {
		System.out.println("From Emp constr...");
	}
	
	/*public Employee(int eid)
	{
		this.eid=eid;
		//this.ename=ename;
	}*/
	
	public void setEid(int eid)
	{
		this.eid=eid;
	}
	public int getEid()
	{
		return eid;
	}
	public void setEname(String ename)
	{
		this.ename=ename;
	}
	public String getEname()
	{
		return ename;
	}
	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", salary=" + salary + "]";
	}
	
	public static Comparator<Employee> nameComparator=new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			// TODO Auto-generated method stub
			return (e1.getEname().compareTo(e2.getEname()));
		}
		
	};

	
}
