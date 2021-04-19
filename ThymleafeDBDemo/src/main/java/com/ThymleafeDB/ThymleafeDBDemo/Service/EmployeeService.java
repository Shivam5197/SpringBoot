package com.ThymleafeDB.ThymleafeDBDemo.Service;

import java.util.List;


import com.ThymleafeDB.ThymleafeDBDemo.Entity.Employee;


public interface EmployeeService {

	public List<Employee> getListOfAllEmployees();
	public Employee getEmployeeByID(int id);
	public void SaveEmployee(Employee employee);
	public void Delete(int id);
}
