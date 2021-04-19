package com.ThymleafeDB.ThymleafeDBDemo.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ThymleafeDB.ThymleafeDBDemo.DAO.EmployeeDAO;
import com.ThymleafeDB.ThymleafeDBDemo.Entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO empl) {
		this.employeeDao=empl;
	}


	@Override
	@Transactional
	public List<Employee> getListOfAllEmployees() {
		return employeeDao.getListOfAllEmployees();
	}


	@Override
	@Transactional
	public Employee getEmployeeByID(int id) {
		return employeeDao.getEmployeeByID(id);
	}


	@Override
	@Transactional
	public void SaveEmployee(Employee employee) {
		employeeDao.SaveEmployee(employee);
	}


	@Override
	@Transactional
	public void Delete(int id) {
		employeeDao.Delete(id);
	}	
}
