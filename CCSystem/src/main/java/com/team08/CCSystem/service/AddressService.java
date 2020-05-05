/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.List;

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
	
	public List<Address> findAll() {
		return addressRepository.findAll();
	}
	
	public Address save(Address address) {
		return addressRepository.save(address);
	}
	
	public void remove(Long id) {
		addressRepository.deleteById(id);
	}
	
}
