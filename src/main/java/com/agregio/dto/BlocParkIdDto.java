package com.agregio.dto;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

public class BlocParkIdDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5983343382292793901L;
	
	Long idBloc;
	
	Long idPark;

	private BlocParkIdDto() {
	}

	public BlocParkIdDto(Long blocId, Long parkId) {
		super();
		this.idBloc = blocId;
		this.idPark = parkId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idBloc, idPark);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlocParkIdDto other = (BlocParkIdDto) obj;
		return Objects.equals(idBloc, other.idBloc) && Objects.equals(idPark, other.idPark);
	}

	public Long getIdBloc() {
		return idBloc;
	}

	public void setIdBloc(Long idBloc) {
		this.idBloc = idBloc;
	}

	public Long getIdPark() {
		return idPark;
	}

	public void setIdPark(Long idPark) {
		this.idPark = idPark;
	}
	
	
	
	
	
	

}
