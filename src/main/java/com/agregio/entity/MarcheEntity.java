package com.agregio.entity;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="marche")
public class MarcheEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	 @Column
	private String name;
	 
	 
	 @OneToMany(mappedBy = "marche", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<OffreEntity> offres = new HashSet();
	public Set<OffreEntity> getOffres() {
		return offres;
	}
	public void setOffres(Set<OffreEntity> offres) {
		this.offres = offres;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "MarcheEntity [id=" + id + ", name=" + name + ", offres=" + offres + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name, offres);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MarcheEntity other = (MarcheEntity) obj;
		return Objects.equals(id, other.id) ;
	}
	

}
