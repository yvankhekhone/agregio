package com.agregio.service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.agregio.dao.IBlocDao;
import com.agregio.dao.IOffreDao;
import com.agregio.dto.OffreDto;
import com.agregio.entity.BlocEntity;
import com.agregio.entity.MarcheEntity;
import com.agregio.entity.OffreEntity;
import com.agregio.transformer.OffreTransformer;

@Service
public class OffreServiceImpl implements IOffreService {

	@Autowired
	private IOffreDao offreDao;
	@Autowired
	private IBlocDao blocDao;
	
	@Autowired
	private OffreTransformer offreTransformer;

	@Override
	@Transactional
	public Long saveOffre(OffreDto offre) {

		OffreEntity offreEntity = new OffreEntity();
		MarcheEntity marche = new MarcheEntity();
		marche.setId(1L);
		Set<BlocEntity> blocs = new HashSet();
		BlocEntity bloc = new BlocEntity();
		bloc.setId(1L);
		bloc.setOffre(offreEntity);
		offreEntity.getBlocs().add(bloc);
		offreEntity.setMarche(marche);
		offreDao.save(offreEntity);
		return null;
	}

	@Override
	public Map<Long, List<OffreDto>> findAllGroupByMarche() {
		List<OffreEntity> offres =offreDao.findAll();
		List<OffreDto> offresDto = offreTransformer.toModel(offres);
		return offresDto.stream().collect(Collectors.groupingBy(t -> t.getMarche().getId()));
		
	}
	

}
