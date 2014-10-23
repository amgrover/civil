package org.appfuse.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;

@Entity
@Table

public class Section implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4932776918215641165L;

	private Long id;

	private Set<TireType> tireTypes;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "section_tire_types", joinColumns = { @JoinColumn(name = "section_id") }, inverseJoinColumns = @JoinColumn(name = "tire_type_id"))
	public Set<TireType> getTireTypes() {
		return tireTypes;
	}

	public void setTireTypes(Set<TireType> tireTypes) {
		this.tireTypes = tireTypes;
	}

	public void addTireType(TireType tireType) {
		if (tireTypes == null) {
			tireTypes = new HashSet<TireType>();
		}
		getTireTypes().add(tireType);
	}

}
