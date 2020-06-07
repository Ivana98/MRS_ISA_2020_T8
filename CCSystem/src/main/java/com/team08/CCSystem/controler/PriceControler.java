/**
 * 
 */
package com.team08.CCSystem.controler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team08.CCSystem.dto.FullPriceDTO;
import com.team08.CCSystem.dto.MedicalRoomDTO;
import com.team08.CCSystem.dto.PriceListDTO;
import com.team08.CCSystem.model.MedicalRoom;
import com.team08.CCSystem.model.Price;
import com.team08.CCSystem.service.PriceService;

/**
 * @author Veljko
 *
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/prices")
public class PriceControler {
	
	@Autowired
	private PriceService priceService;
	
	@GetMapping(value = "/getOne/{id}")
	public ResponseEntity<PriceListDTO> getOne(@PathVariable Long id) {
		
		Price price = priceService.findOne(id);
		
		if (price == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<>(new PriceListDTO(price), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getAllFromClinic/{clinicId}")
	public ResponseEntity<List<FullPriceDTO>> getAllFromClinic(@PathVariable Long clinicId) {
		
		List<Price> prices = priceService.findAllFromClinic(clinicId);
		
		List<FullPriceDTO> pricesDTO = new ArrayList<>();
		for (Price price : prices) {
			pricesDTO.add(new FullPriceDTO(price));
//			System.out.println(new FullPriceDTO(price));
		}
		
		return new ResponseEntity<>(pricesDTO, HttpStatus.OK);
	}
	
	@PutMapping(path = "modify")
	public ResponseEntity<FullPriceDTO> modify(@RequestBody FullPriceDTO fullPriceDTO) {
		
		return priceService.modify(fullPriceDTO);
	}

}
