package com.agregio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agregio.dao.IParkDao;
import com.agregio.dto.ParkDto;
import com.agregio.entity.ParkEntity;
import com.agregio.service.IParkService;

@RestController
@RequestMapping("api/park")
public class ParkController {

	@Autowired
	IParkService parkService;
	
	@Autowired
	IParkDao parkDao;


	@PostMapping
	public ResponseEntity<ParkDto> createPark(@RequestBody ParkDto park) {
		  ParkDto result = parkService.createPark(park);
		return  new ResponseEntity<>(result, HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public List<ParkEntity> findAll() {
		  return parkDao.findAll();
	}
	
	@GetMapping("/getParkByMarcheId")
	public List<ParkDto> getParkByMarcheId(@RequestParam("id") Long id ) {
		
		  return parkService.getParkByMarcheId(id);
	}
}
