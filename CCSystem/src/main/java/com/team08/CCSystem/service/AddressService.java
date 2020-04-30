/**
 * 
 */
package com.team08.CCSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.Address;
import com.team08.CCSystem.repository.AddressRepository;

/**
 * @author Veljko
 *
 */
@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	public Address findOne(Long id) {
		return addressRepository.findById(id).orElseGet(null);
	}
	
}
