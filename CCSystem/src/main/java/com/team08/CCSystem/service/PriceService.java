/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.FullPriceDTO;
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
	
	@Autowired
	private PriceService priceService;
	
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
	
	public List<Price> findAllFromClinic(Long clinicId) {
		return priceRepository.findAllFromClinic(clinicId);
	}

	/**
	 * @param fullPriceDTO
	 * @return
	 */
	public ResponseEntity<FullPriceDTO> modify(FullPriceDTO fullPriceDTO) {

		Price price = priceService.findOne(fullPriceDTO.getId());
		
		if (price == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		price.setDiscount(fullPriceDTO.getDiscount());
		price.setPrice(fullPriceDTO.getPrice());
		
		price = priceService.save(price);
		
		return new ResponseEntity<>(new FullPriceDTO(price), HttpStatus.OK);
	}

}
