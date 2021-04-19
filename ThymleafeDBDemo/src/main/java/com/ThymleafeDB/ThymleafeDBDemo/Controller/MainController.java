package com.ThymleafeDB.ThymleafeDBDemo.Controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ThymleafeDB.ThymleafeDBDemo.Entity.Employee;
import com.ThymleafeDB.ThymleafeDBDemo.Service.EmployeeService;

//@RestController
@Controller
@RequestMapping("/api")
public class MainController {

	private static final Logger LOGGER = LogManager.getLogger(MainController.class);
	
	private EmployeeService employee;
	@Autowired
	public MainController(EmployeeService eml) {
		this.employee=eml;
	}
		
	@RequestMapping(value="/allEmployees",method = {RequestMethod.GET,RequestMethod.POST})
	public String getList(Model theModel) {
		List<Employee> employesList ;
		employesList = employee.getListOfAllEmployees();
		if(!employesList.isEmpty()) {
		theModel.addAttribute("listEmployees", employesList);
		LOGGER.info("EmpoloyeeList : " + employesList);
		return "Employees/employees";
		}else {
			return "errorPage";
		}
	}
	
	@RequestMapping(value="/showForm")
	public String showForm(Model theModel) {
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employeeForm" , theEmployee);
		return "Employees/form";
	}
	
	@RequestMapping(value="/save" , method = {RequestMethod.POST,RequestMethod.GET})
	public String SaveEmployee(@ModelAttribute("employeeForm") Employee theEmployee) {
		employee.SaveEmployee(theEmployee);
		return "redirect:/api/allEmployees";
	}

	
}
