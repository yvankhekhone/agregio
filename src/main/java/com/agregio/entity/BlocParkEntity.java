package com.agregio.entity;

import java.math.BigDecimal;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity(name="BlocParkEntity")
@Table(name="bloc_park")
public class BlocParkEntity {
	
	

	@EmbeddedId
	private BlocParkId id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("idPark")
	private ParkEntity park; 
	
	@ManyToOne(fetch=FetchType.LAZY)
	@MapsId("idBloc")
	private BlocEntity bloc;
	@Column(name="quantity_mw")
	private BigDecimal quantityMw;

	public BlocParkEntity(BlocEntity blocEntity, ParkEntity park) {
		this.bloc=blocEntity;
		this.park=park;
		this.id= new BlocParkId(blocEntity.id,park.id);
		// TODO Auto-generated constructor stub
	}

	
	public BlocParkId getId() {
		return id;
	}

	public void setId(BlocParkId id) {
		this.id = id;
	}

	public ParkEntity getPark() {
		return park;
	}

	public void setPark(ParkEntity park) {
		this.park = park;
	}

	public BlocEntity getBloc() {
		return bloc;
	}

	public void setBloc(BlocEntity bloc) {
		this.bloc = bloc;
	}

	public BigDecimal getQuantityMw() {
		return quantityMw;
	}

	public void setQuantityMw(BigDecimal quantityMw) {
		this.quantityMw = quantityMw;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bloc, id, park);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlocParkEntity other = (BlocParkEntity) obj;
		return Objects.equals(bloc, other.bloc) && Objects.equals(id, other.id) && Objects.equals(park, other.park);
	} 
	
	@Override
	public String toString() {
		return "BlocParkEntity [id=" + id + ", park=" + park + ", bloc=" + bloc + "]";
	}
}
