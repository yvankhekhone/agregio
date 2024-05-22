package com.agregio.service;

import java.util.List;
import java.util.Map;

import com.agregio.dto.OffreDto;

public interface IOffreService {
	
	
	public  Long saveOffre(OffreDto offre);

	
	public Map<Long, List<OffreDto>> findAllGroupByMarche();


	

}
