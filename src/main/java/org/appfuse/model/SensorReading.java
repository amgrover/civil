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
import org.hibernate.engine.Cascade;

@Entity
@Table
public class SensorReading implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7028072125257636910L;
	private Long id;
	private String metric;
	private Set<Reading> timeReading;
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

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "sensor_reading", joinColumns = { @JoinColumn(name = "sensor_id") }, inverseJoinColumns = @JoinColumn(name = "reading_id"))
	public Set<Reading> getTimeReading() {
		return timeReading;
	}

	public void setTimeReading(Set<Reading> timeReading) {
		this.timeReading = timeReading;
	}

	public void addTimeReading(Reading reading) {
		if (timeReading == null) {
			timeReading = new HashSet<Reading>();
		}

		timeReading.add(reading);
	}

}
