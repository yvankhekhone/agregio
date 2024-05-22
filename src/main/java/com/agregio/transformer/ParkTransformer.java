package com.agregio.transformer;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.agregio.dto.BlocParkDto;
import com.agregio.dto.ParkDto;
import com.agregio.entity.ParkEntity;
@Component("parkTransformer")
public class ParkTransformer implements ITransformer<ParkEntity,ParkDto>  {

	
	@Override
	public ParkDto toModel(ParkEntity entity) {
		 ParkDto destination = BeanUtils.instantiateClass(ParkDto.class);
		BeanUtils.copyProperties(entity, destination);
		return destination;
	}

	@Override
	public ParkEntity toEntity(ParkDto model) {
		ParkEntity entity = BeanUtils.instantiateClass(ParkEntity.class);
		BeanUtils.copyProperties(model, entity);
		return entity;
	}

	@Override
	public List<ParkEntity> toEntities(List<ParkDto> model) {
		
		return model.stream().map(e->this.toEntity(e)).toList();
	
	}

	@Override
	public List<ParkDto> toModel(List<ParkEntity> entity) {
		return entity.stream().map(e->this.toModel(e)).toList();
			}

}
