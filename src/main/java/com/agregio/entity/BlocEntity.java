package com.agregio.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bloc")
public class BlocEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name = "start_bloc")
	LocalDateTime startBloc;

	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "id_offre")
	OffreEntity offre;
	// Minimum quantity acceptance to validate Bloc
	@Column(name = "min_quantity_mw")
	BigDecimal minQuantityMw;

	@OneToMany(mappedBy = "bloc")
	List<BlocParkEntity> parks = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffreEntity getOffre() {
		return offre;
	}

	public void setOffre(OffreEntity offre) {
		this.offre = offre;
	}

	public LocalDateTime getStartBloc() {
		return startBloc;
	}

	public void setStartBloc(LocalDateTime startBloc) {
		this.startBloc = startBloc;
	}

	public BigDecimal getMinQuantityMw() {
		return minQuantityMw;
	}

	public void setMinQuantityMw(BigDecimal minQuantityMw) {
		this.minQuantityMw = minQuantityMw;
	}

	public List<BlocParkEntity> getParks() {
		return parks;
	}

	public void setParks(List<BlocParkEntity> parks) {
		this.parks = parks;
	}

	public void addPark(ParkEntity park) {
		BlocParkEntity blocPark = new BlocParkEntity(this, park);
		parks.add(blocPark);
		park.getBlocs().add(blocPark);

	}

	public void removePark(ParkEntity park) {
		for (Iterator<BlocParkEntity> iterator = parks.iterator(); iterator.hasNext();) {
			BlocParkEntity blocParkEntity = iterator.next();

			if (blocParkEntity.getBloc().equals(this) && blocParkEntity.getPark().equals(park)) {
				iterator.remove();
				blocParkEntity.getPark().getBlocs().remove(park);
				blocParkEntity.setBloc(null);
				blocParkEntity.setPark(null);
			}
		}

	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return id!=null && id.equals(((BlocEntity)obj).getId());
	}

	@Override
	public String toString() {
		return "BlocEntity [id=" + id + ", startBloc=" + startBloc + ", minQuantityMw=" + minQuantityMw + ", parks="
				+ parks + "]";
	}

}
