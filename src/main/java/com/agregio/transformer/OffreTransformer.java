package com.agregio.transformer;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.agregio.dto.MarcheDto;
import com.agregio.dto.OffreDto;
import com.agregio.entity.MarcheEntity;
import com.agregio.entity.OffreEntity;
@Component("offreTransformer")
public class OffreTransformer implements ITransformer<OffreEntity,OffreDto>  {

	

	@Override
	public OffreDto toModel(OffreEntity entity) {
		 OffreDto destination = BeanUtils.instantiateClass(OffreDto.class);
		BeanUtils.copyProperties(entity, destination);
		MarcheDto marchenewDto = new MarcheDto();
		if(entity.getMarche()!= null) {
			marchenewDto.setId(entity.getId());
			marchenewDto.setName(entity.getMarche().getName());	
		}
		
		destination.setMarche(marchenewDto);
		return destination;
	}

	@Override
	public OffreEntity toEntity(OffreDto model) {
		OffreEntity entity = BeanUtils.instantiateClass(OffreEntity.class);
			BeanUtils.copyProperties(model, entity);
			MarcheEntity marche = new MarcheEntity();
			if(model.getMarche()!= null) {
				marche.setId(model.getId());
				marche.setName(model.getMarche().getName());	
			}
		return entity;
	}

	@Override
	public List<OffreEntity> toEntities(List<OffreDto> model) {
		if(model!=null) {
			 return model.stream().map(e-> toEntity(e)).toList();
		}
		return null;
	}

	@Override
	public List<OffreDto> toModel(List<OffreEntity> entity) {
		if(entity!=null) {
			 return entity.stream().map(e-> toModel(e)).toList();
		}
		return null;
	}
}
