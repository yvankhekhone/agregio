package com.agregio.dto;

import java.util.List;

public class OffreDto {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public MarcheDto getMarche() {
		return marche;
	}
	public void setMarche(MarcheDto marche) {
		this.marche = marche;
	}
	public List<BlocDto> getBlocs() {
		return blocs;
	}
	public void setBlocs(List<BlocDto> blocs) {
		this.blocs = blocs;
	}
	Long id ; 
	MarcheDto marche;
	List<BlocDto> blocs;

}
