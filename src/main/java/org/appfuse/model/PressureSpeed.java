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

public class PressureSpeed implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8489302034855644131L;
	private Long id;
	private Set<Repetition> repetitions;
	private float pressure;
	private float speed;
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
	@JoinTable(name = "psi_rep", joinColumns = { @JoinColumn(name = "psi_id") }, inverseJoinColumns = @JoinColumn(name = "rep_id"))
	public Set<Repetition> getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(Set<Repetition> repetitions) {
		this.repetitions = repetitions;
	}

	public float getPressure() {
		return pressure;
	}

	public void setPressure(float pressure) {
		this.pressure = pressure;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public void addRepetition(Repetition repetition) {
		if (repetitions == null) {
			repetitions = new HashSet<Repetition>();
		}
		repetitions.add(repetition);
	}

}
