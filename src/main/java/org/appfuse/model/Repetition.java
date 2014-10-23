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

@Entity
@Table
public class Repetition implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7765091119361308188L;
	private Long id;
	private Set<SensorReading> readings;
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
	@JoinTable(name = "rep_sensor", joinColumns = { @JoinColumn(name = "rep_id") }, inverseJoinColumns = @JoinColumn(name = "sensor_id"))
	public Set<SensorReading> getReadings() {
		return readings;
	}

	public void setReadings(Set<SensorReading> readings) {
		this.readings = readings;
	}

	public void addReadings(SensorReading reading) {
		if (readings == null) {
			readings = new HashSet<SensorReading>();
		}
		readings.add(reading);
	}

}
