package com.agregio.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
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
@Table(name = "offre")
public class OffreEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = MarcheEntity.class)
	@JoinColumn(name = "marche_id")
	MarcheEntity marche;
	@OneToMany(mappedBy = "offre",cascade=CascadeType.ALL)
	Set<BlocEntity> blocs = new HashSet();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MarcheEntity getMarche() {
		return marche;
	}

	public void setMarche(MarcheEntity marche) {
		this.marche = marche;
	}

	public Set<BlocEntity> getBlocs() {
		return blocs;
	}

	public void setBlocs(Set<BlocEntity> blocs) {
		this.blocs = blocs;
	}

	@Override
	public String toString() {
		return "OffreEntity [id=" + id + ", marche=" + marche + ", blocs=" + blocs + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(blocs, id, marche);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OffreEntity other = (OffreEntity) obj;
		return Objects.equals(id, other.id);
	}

}
