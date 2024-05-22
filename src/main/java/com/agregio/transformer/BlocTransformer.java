package com.agregio.transformer;

import java.util.List;

import org.springframework.stereotype.Component;

import com.agregio.dto.BlocDto;
import com.agregio.entity.BlocEntity;
@Component("blocTransformer")
public class BlocTransformer implements ITransformer<BlocEntity,BlocDto>  {

	@Override
	public BlocDto toModel(BlocEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlocEntity toEntity(BlocDto model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlocEntity> toEntities(List<BlocDto> model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BlocDto> toModel(List<BlocEntity> entity) {
		// TODO Auto-generated method stub
		return null;
	}


}
