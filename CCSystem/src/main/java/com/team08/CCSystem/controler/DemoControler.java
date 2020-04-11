package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.model.Employee;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DemoControler {
	
	private List<Employee> employees = createList2();

	public List<Employee> firstPage() {
		return employees;
	}
	
	private List<Employee> createList2() {
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

	/**
	 * Create 2 employees
	 * 
	 * @return List<Employee>
	 */
//	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	@GetMapping("/employees")  // Much easier :)
	private List<Employee> createList() {
		List<Employee> emps = new ArrayList<>();
		
		emps = employees;
		return emps;
	}

	/**
	 * Remove chosen employee from employees list
	 * 
	 * @param id
	 * @return deleted Employee
	 */
	@DeleteMapping("/employees/{id}")
//	@DeleteMapping(path = {"/{id}"})
	public Employee delete(@PathVariable("id") String id) {
		Employee delEmp = null;
		for (Employee emp : employees) {
			if (emp.getEmpId().equals(id)) {
				employees.remove(emp);
				delEmp = emp;
				break;
			}
		}
		return delEmp;
	}
	
	@PostMapping("/employees")
	public Employee create(@RequestBody Employee user) {
		employees.add(user);
		return user;
	}

}
