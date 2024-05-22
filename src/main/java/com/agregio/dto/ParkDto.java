package com.agregio.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.NaturalId;

import com.agregio.entity.BlocParkEntity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

public class ParkDto {
	Long id ; 
	String type; 	
	String name; 
	List<BlocParkDto> blocs= new ArrayList<>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<BlocParkDto> getBlocs() {
		return blocs;
	}
	public void setBlocs(List<BlocParkDto> blocs) {
		this.blocs = blocs;
	}
	

}
