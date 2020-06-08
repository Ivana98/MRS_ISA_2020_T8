/**
 * 
 */
package com.team08.CCSystem.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.team08.CCSystem.dto.FullPriceDTO;
import com.team08.CCSystem.model.Clinic;
import com.team08.CCSystem.model.Examination;
import com.team08.CCSystem.model.ExaminationType;
import com.team08.CCSystem.model.Price;
import com.team08.CCSystem.model.enums.InterventionType;
import com.team08.CCSystem.model.enums.Specialisation;
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
	
	@Autowired
	private ExaminationService examinationService;
	
	@Autowired ClinicService clinicService;
	
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

	/**
	 * Delete price if there is no examinations in future with this price.
	 * 
	 * @param id is price id
	 * @return true if et (price) is deleted.
	 */
	public ResponseEntity<Boolean> delete(Long id) {

		Price price = priceService.findOne(id);
		
		if (price == null) return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		
		Date date = new Date();
		
		List<Examination> examinations = examinationService.findExaminationsAfterDateAndClinicIdAndPriceId(date, price.getClinic().getId(), price.getId());
		
		if (examinations.isEmpty() || examinations == null || examinations.size() == 0) {
			remove(id);
			return new ResponseEntity<>(true, HttpStatus.OK);
		} else {
			System.out.println("Cannot delete price because there is examinations in future with this price.");
			return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * @param fullPriceDTO
	 * @return 
	 */
	public ResponseEntity<FullPriceDTO> add(FullPriceDTO fullPriceDTO) {
		
		System.out.println(fullPriceDTO);

		List<Price> prices = priceService.findAllFromClinic(fullPriceDTO.getClinic_id());
		
		for (Price price : prices) {
			if (price.getExaminationType().getInterventionType() == InterventionType.valueOf(fullPriceDTO.getIntervention_type()) && price.getExaminationType().getSpecialisation() == Specialisation.valueOf(fullPriceDTO.getSpecialisation())) 
				return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
		}
		
		ExaminationType examinationType = new ExaminationType(null, fullPriceDTO.getDuration(), InterventionType.valueOf(fullPriceDTO.getIntervention_type()), Specialisation.valueOf(fullPriceDTO.getSpecialisation()));
		Clinic clinic = clinicService.findOne(fullPriceDTO.getClinic_id());
		Price price = new Price(null, fullPriceDTO.getPrice(), examinationType, fullPriceDTO.getDiscount(), clinic);
		
		priceService.save(price);
		
		return new ResponseEntity<>(fullPriceDTO, HttpStatus.OK);
	}

}
