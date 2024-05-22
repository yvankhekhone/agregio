package com.agregio.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="park")
@Cache(usage= CacheConcurrencyStrategy.READ_WRITE)
public class ParkEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id ;
	@Column
	String type; 
	
	@Column
	String name; 
	@OneToMany(mappedBy="park")
	List<BlocParkEntity> blocs= new ArrayList<>();

	
	public ParkEntity() {
	
	}

	public ParkEntity(String type, String name) {
		this.type = type;
		this.name = name;
		
		// TODO Auto-generated constructor stub
	}
	public ParkEntity(String name) {
		this.name = name;
		// TODO Auto-generated constructor stub
	}

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

	
	public List<BlocParkEntity> getBlocs() {
		return blocs;
	}

	public void setBlocs(List<BlocParkEntity> blocs) {
		this.blocs = blocs;
	}

	@Override
	public int hashCode() {
		return Objects.hash(blocs, id, name, type);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkEntity other = (ParkEntity) obj;
		return  Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "ParkEntity [id=" + id + ", type=" + type + ", name=" + name + ", blocs=" + blocs + "]";
	}



	
	
}
