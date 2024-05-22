package com.agregio.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.agregio.entity.ParkEntity;

public interface IParkDao extends JpaRepository<ParkEntity, Long> {
	
	@Query(value= "SELECT  p.* FROM park p , bloc_park bp , bloc b, offre, marche m"
			+ " WHERE p.id = bp.id_park AND bp.id_bloc=b.id AND b.id_offre = offre.id AND m.id = offre.marche_id AND m.id= :id",nativeQuery = true)
	public List<ParkEntity>getParkByMarcheId(@Param("id") Long id);
	
}
