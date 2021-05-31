package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCotroller {

	
	@GetMapping("/test")
	public VaccineDTO test() {
		
		
		//populated here for demo but assume this is fetched from db:
		Vaccine vaccine = new Vaccine();
		vaccine.setName("Covaxin");
		vaccine.setManufacturer("Adar and Co");
		vaccine.setQuantity(100);
		Dosage dosage = new Dosage();
		dosage.setNoOfDosesRequired(2);
		dosage.setGapBetweenDoses(5);
		vaccine.setDosage(dosage);
		
	
		
		VaccineMapper mapper = VaccineMapper.INSTANCE;
		
		
		VaccineDTO dto = mapper.fromVaccine(vaccine);
		
		Location location = new Location();
		location.setCity("Chennai");
		location.setCountry("India");
		location.setState("Tamilnadu");
		
		
		mapper.updateLocation(location, dto);
		
		
		return dto;
		
	}
}
