/**
 * 
 */
package com.team08.CCSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.Person;
import com.team08.CCSystem.repository.PersonRepository;

/**
 * @author Veljko
 *
 */
@Service
public class PersonService {
	
//	@Autowired
	private PersonRepository persons;
	
	public Person findOne(long id) {
		return persons.findById(id).orElse(null);
	}
	
	public Person save(Person person) {
		return persons.save(person);
	}
	
}
