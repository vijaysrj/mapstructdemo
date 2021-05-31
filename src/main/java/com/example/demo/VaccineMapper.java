package com.example.demo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VaccineMapper {
	
	VaccineMapper INSTANCE = Mappers.getMapper(VaccineMapper.class);

	@Mapping(source="manufacturer",target="company")
	@Mapping(source="quantity",target="totalno")
	@Mapping(source="dosage.noOfDosesRequired",target="totalDoses")
	@Mapping(source="dosage.gapBetweenDoses",target="dosageGap")
	VaccineDTO fromVaccine(Vaccine vaccine);
	
	
	void updateLocation(Location location, @MappingTarget VaccineDTO vaccineDTO);
}
