package com.agregio.dao.transformer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.agregio.AbstractTest;
import com.agregio.dto.ParkDto;
import com.agregio.entity.ParkEntity;
import com.agregio.transformer.ITransformer;


public class ParkTransformerTest extends AbstractTest {

	@Autowired
	@Qualifier("parkTransformer")
	ITransformer<ParkEntity, ParkDto> parkTransformer;

	@Test
	void parkTransformerToEntity() {
		ParkDto val = new ParkDto();
		val.setId(1L);
		val.setName("nameTest");
		val.setType("typeTest");

		ParkEntity result = parkTransformer.toEntity(val);
		Assertions.assertEquals(result.getId(), val.getId());
		Assertions.assertEquals(result.getName(), val.getName());
		Assertions.assertEquals(result.getType(), val.getType());
	}

	@Test
	void parkTransformerToModel() {
		ParkEntity val = new ParkEntity();
		val.setId(1L);
		val.setName("nameTest");
		val.setType("typeTest");

		ParkDto result = parkTransformer.toModel(val);
		Assertions.assertEquals(result.getId(), val.getId());
		Assertions.assertEquals(result.getName(), val.getName());
		Assertions.assertEquals(result.getType(), val.getType());
	}
}
