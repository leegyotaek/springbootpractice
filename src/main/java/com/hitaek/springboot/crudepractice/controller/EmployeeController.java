package com.hitaek.springboot.crudepractice.controller;

import java.util.List;

import com.hitaek.springboot.crudepractice.entity.Employee;
import com.hitaek.springboot.crudepractice.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listEmployees(Model theModel) {
		
		// get employees from db
		List<Employee> theEmployees = employeeService.findAll();
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		return "employees/list-employees";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel){

		// create model attribute to bind form data
		Employee employee = new Employee();

		theModel.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("employee") Employee theEmployee){

		employeeService.save(theEmployee);

		return "redirect:/employees/list";


	}

	@GetMapping("/showFormForUpdate")
	public String showFormForAdd(@RequestParam("employeeId") int theId,
								 Model theModel){

		// create model attribute to bind form data
		Employee employee = employeeService.findById(theId);

		theModel.addAttribute("employee", employee);

		return "employees/employee-form";
	}

	@GetMapping("/delete")
	public String deleteEmployee(@RequestParam("employeeId") int theId){
		employeeService.deleteById(theId);

		return "redirect:/employees/list";
	}
}









