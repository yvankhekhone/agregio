package com.agregio.transformer;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.agregio.dto.BlocParkDto;
import com.agregio.dto.BlocParkIdDto;
import com.agregio.dto.OffreDto;
import com.agregio.entity.BlocParkEntity;
import com.agregio.entity.BlocParkId;
@Component("BlocParkTransformer")
public class BlocParkTransformer implements ITransformer<BlocParkEntity,BlocParkDto> {

	@Autowired
	BlocTransformer blocTransformer;
	
	@Autowired
	ParkTransformer ParkTransformer;
	
	@Override
	public BlocParkDto toModel(BlocParkEntity entity) {
		BlocParkDto destination = BeanUtils.instantiateClass(BlocParkDto.class);
			BeanUtils.copyProperties(entity, destination);
			destination.setId(new BlocParkIdDto(entity.getBloc().getId(),entity.getPark().getId()));
			destination.setBloc(blocTransformer.toModel(entity.getBloc()));
			destination.setPark(ParkTransformer.toModel(entity.getPark()));
		return destination;
	}

	@Override
	public BlocParkEntity toEntity(BlocParkDto model) {
		// TODO Auto-generated method stub
		BlocParkEntity destination = BeanUtils.instantiateClass(BlocParkEntity.class);
		BeanUtils.copyProperties(model, destination);
		destination.setId(null);
		destination.setBloc(blocTransformer.toEntity(model.getBloc()));
		destination.setPark(ParkTransformer.toEntity(model.getPark()));
		return destination;
	}

	@Override
	public List<BlocParkEntity> toEntities(List<BlocParkDto> model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlocParkDto> toModel(List<BlocParkEntity> entity) {
		// TODO Auto-generated method stub
		return null;
	}

		

}
