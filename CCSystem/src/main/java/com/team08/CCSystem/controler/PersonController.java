/**
 * 
 */
package com.team08.CCSystem.controler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.model.Person;
import com.team08.CCSystem.service.PersonService;

/**
 * @author Veljko
 *
 */
@RestController
@RequestMapping("/api")
public class PersonController {

//	@Autowired
	private PersonService service;
	
	@PostMapping("/persons")
	public ResponseEntity<Person> addPerson(@RequestBody Person person) {
		
		System.out.println("Adding a person...");
		System.out.println(person);
		
		service.save(person);
		System.out.println("Database is ok");
		return new ResponseEntity<>(person, HttpStatus.OK);
	}
	
	@GetMapping("/rooms/{id}")
	public ResponseEntity<Person> getRoom(@PathVariable("id") long id) {
		
		Person person = service.findOne(id);

		// room must exist
		if (person == null)
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(person, HttpStatus.OK);

	}
}
