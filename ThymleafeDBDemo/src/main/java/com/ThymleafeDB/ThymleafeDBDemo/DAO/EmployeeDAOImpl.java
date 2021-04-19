package com.ThymleafeDB.ThymleafeDBDemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ThymleafeDB.ThymleafeDBDemo.Entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeDAOImpl.class);
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImpl(EntityManager newEntityManager) {
		this.entityManager = newEntityManager;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getListOfAllEmployees() {
		Query query = entityManager.createQuery("from Employee");
		List<Employee> employees = query.getResultList();
		LOGGER.info(employees);
		return employees;
	}


	@Override
	public Employee getEmployeeByID(int id) {
		Employee employee = entityManager.find(Employee.class,id);
		return employee;
	}


	@Override
	public void SaveEmployee(Employee employee) {
		entityManager.merge(employee);
	}


	@Override
	public void Delete(int id) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=: employeeID");
		theQuery.setParameter("employeeID", id);
		theQuery.executeUpdate();
	}
	
	
	
}
