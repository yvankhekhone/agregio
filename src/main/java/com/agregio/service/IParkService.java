package com.agregio.service;

import java.util.List;

import com.agregio.dto.ParkDto;

public interface IParkService {
	
	
	ParkDto createPark(ParkDto park);
	
	
	List<ParkDto> getParkByMarcheId(Long id);

}
