package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DemoControler {
	
	private List<Employee> employees = createList();

	public List<Employee> firstPage() {
		return employees;
	}
	
	/**
	 * Create 2 employees
	 * 
	 * @return List<Employee>
	 */
//	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	@GetMapping("/employees")  // Much easier :)
	private List<Employee> createList() {
		List<Employee> emps = new ArrayList<>();
		
		Employee emp1 = new Employee();
		emp1.setName("emp1");
		emp1.setDesignation("manager");
		emp1.setEmpId("1");
		emp1.setSalary(3000);

		Employee emp2 = new Employee();
		emp2.setName("emp2");
		emp2.setDesignation("developer");
		emp2.setEmpId("2");
		emp2.setSalary(3000);
		
		emps.add(emp1); emps.add(emp2); // Add employees to arrayList
		
		return emps;
	}

}
