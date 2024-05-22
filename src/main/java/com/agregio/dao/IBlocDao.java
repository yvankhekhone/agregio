package com.agregio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agregio.entity.BlocEntity;

public interface IBlocDao extends JpaRepository<BlocEntity, Long> {
	

}
