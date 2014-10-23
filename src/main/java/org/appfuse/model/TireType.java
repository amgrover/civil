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
import javax.persistence.Transient;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;

@Entity
@Table
public class TireType implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5209472000426719626L;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "tire_type_load", joinColumns = { @JoinColumn(name = "tire_type_id") }, inverseJoinColumns = @JoinColumn(name = "load_id"))
	private Set<Load> loads;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Load> getLoads() {
		return loads;
	}

	public void setLoads(Set<Load> loads) {
		this.loads = loads;
	}

	public void addLoad(Load load) {
		if (loads == null) {
			loads = new HashSet<Load>();
		}
		loads.add(load);
	}

}
