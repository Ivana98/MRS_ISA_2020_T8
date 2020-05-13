/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.model.Price;
import com.team08.CCSystem.repository.PriceRepository;

/**
 * @author Veljko
 *
 */
@Service
public class PriceService {
	
	@Autowired
	private PriceRepository priceRepository;
	
	public Price findOne(Long id) {
		return priceRepository.findById(id).orElseGet(null);
	}
	
	public List<Price> findAll() {
		return priceRepository.findAll();
	}
	
	public Price save(Price priceList) {
		return priceRepository.save(priceList);
	}
	
	public void remove(Long id) {
		priceRepository.deleteById(id);
	}

}
