package com.agregio.dao;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.util.Assert;

import com.agregio.Agregio;
import com.agregio.AbstractTest;
import com.agregio.TypePark;
import com.agregio.entity.ParkEntity;


public class ParkDaoTest extends AbstractTest{
	@Autowired
	private IParkDao parkDao;
	
	@Test
	public void testCreatePark() {
		ParkEntity entity = new ParkEntity(TypePark.EOLIENNE.name(), "park1");
		//entity.setId(1L);
		entity.setName("nameTest");
		entity.setType("EOLIENNE");;
		ParkEntity val = parkDao.save(entity);
		
		Optional<ParkEntity> result = parkDao.findById(val.getId());
		Assert.notNull(parkDao.existsById(val.getId()),"result is null");
        Assertions.assertEquals(result.get().getName(), val.getName());
		Assertions.assertEquals(result.get().getId(), val.getId());
		Assertions.assertEquals(result.get().getType(), val.getType());

	}
	
	@Test
	public void getParkByMarcheId() {
		parkDao.getParkByMarcheId(1L);
	}

}
