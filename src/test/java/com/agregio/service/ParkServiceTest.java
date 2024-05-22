package com.agregio.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.agregio.AbstractTest;
import com.agregio.dao.IParkDao;
import com.agregio.dto.ParkDto;
import com.agregio.entity.ParkEntity;
import com.agregio.transformer.ParkTransformer;


public class ParkServiceTest extends AbstractTest{

	@Autowired
	private IParkService parkservice;

	@MockBean
	private ParkTransformer parkTransformer;

	@MockBean
	private IParkDao parkDao;

	@Test
	void createPark() {

		ParkDto parkdto = new ParkDto();
		parkdto.setName("name");
		parkdto.setType("type");

		ParkEntity parkEntity = new ParkEntity();
		parkEntity.setName("name");
		parkEntity.setType("type");
		parkDao.save(parkEntity);

		ParkEntity parkEntitySave = new ParkEntity();
		parkEntitySave.setName("name");
		parkEntitySave.setId(1L);
		parkEntitySave.setType("type");

		ParkDto parkdtoResult = new ParkDto();
		parkdtoResult.setName("name");
		parkdtoResult.setType("type");
		parkdtoResult.setId(1L);

		when(parkTransformer.toEntity(parkdto)).thenReturn(parkEntity);
		when(parkDao.save(parkEntity)).thenReturn(parkEntitySave);
		when(parkTransformer.toModel(parkEntitySave)).thenReturn(parkdtoResult);
		ParkDto result = parkservice.createPark(parkdto);
		Assertions.assertEquals(result, parkdtoResult);

	}

}
