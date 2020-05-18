/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.ClinicAdmin;
import com.team08.CCSystem.model.Doctor;
import com.team08.CCSystem.model.User;
import com.team08.CCSystem.repository.UserRepository;

import javassist.expr.Instanceof;

/**
 * @author Veljko
 *
 */
@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User findOne(Long id) {
		return userRepository.findById(id).orElseGet(null);
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public void remove(Long id) {
		userRepository.deleteById(id);
	}
	
}
