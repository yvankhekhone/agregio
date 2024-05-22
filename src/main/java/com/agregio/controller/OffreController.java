package com.agregio.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agregio.dao.IMarcheDao;
import com.agregio.dto.OffreDto;
import com.agregio.entity.MarcheEntity;
import com.agregio.entity.ParkEntity;
import com.agregio.service.IOffreService;

@RestController
@RequestMapping("/api/offre")
public class OffreController {

	@Autowired
	IOffreService offreService;
  
	@RequestMapping("/createOffre")
	@PostMapping
	public Long createOffres(@RequestBody OffreDto offre) {
		//TODO
		//return offreService.saveOffre(offre);
		 return null;
	}
	
	
	@GetMapping("/findAllOrderByMarche")
	public Map<Long, List<OffreDto>> findAllOrderByMarche() {
		return offreService.findAllGroupByMarche();
	}
}
