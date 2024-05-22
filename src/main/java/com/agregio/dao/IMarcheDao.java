package com.agregio.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agregio.entity.MarcheEntity;

public interface IMarcheDao extends JpaRepository<MarcheEntity, Long> {

	
}
