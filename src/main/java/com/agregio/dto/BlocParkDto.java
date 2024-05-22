package com.agregio.dto;

import java.math.BigDecimal;

import com.agregio.entity.BlocParkId;

public class BlocParkDto {
    
	private BlocParkIdDto id;
	
	private ParkDto park; 
	
	private BlocDto bloc;
	
	private BigDecimal quantityMw;

	public BigDecimal getQuantityMw() {
		return quantityMw;
	}

	public void setQuantityMw(BigDecimal quantityMw) {
		this.quantityMw = quantityMw;
	}

	public BlocParkIdDto getId() {
		return id;
	}

	public void setId(BlocParkIdDto id) {
		this.id = id;
	}

	public ParkDto getPark() {
		return park;
	}

	public void setPark(ParkDto park) {
		this.park = park;
	}

	public BlocDto getBloc() {
		return bloc;
	}

	public void setBloc(BlocDto bloc) {
		this.bloc = bloc;
	}
	
	

}
