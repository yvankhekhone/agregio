package com.agregio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.agregio.dao.IParkDao;
import com.agregio.dto.ParkDto;
import com.agregio.entity.ParkEntity;
import com.agregio.transformer.ITransformer;

@Service
public class ParkServiceImpl implements IParkService {
	
	@Autowired
	IParkDao parkDao;
	
	 @Autowired
	 @Qualifier("parkTransformer")
	 ITransformer<ParkEntity,ParkDto> parkTransformer;
	
	
	 public ParkDto createPark(ParkDto park){	
		 return  parkTransformer.toModel(parkDao.save(parkTransformer.toEntity(park)));
		}


	@Override
	public List<ParkDto> getParkByMarcheId(Long id) {
		 return  parkTransformer.toModel(parkDao.getParkByMarcheId(id));
	}
}
