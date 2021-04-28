package com.mphasis.controller;

import java.util.List;

public interface EmployeeInterface {
	public List addEmployee();
	public void viewEmployee(List elist);
	public void addDept();
	public void viewDept();
	public void sortByName();
	public void sortNameByStream();
	public void deserialize();
	public void serialize();
	public void insertUsingProc();
	public void rsmd();
	public void type_forward_only_rs();
	public void type_scroll_insensitive_rs();
	public void type_scroll_sensitive_rs_insert();
	public void type_scroll_sensitive_rs_update();
	public void batchUpdate();
	
}
