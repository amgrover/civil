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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ @NamedQuery(name = "findStateEntity", query = "select r from StateEntity r where r.name = :name and r.section = :section and r.tireType = :tireType and r.loadNew = :loadNew and r.pressure = :pressure and r.speed = :speed and r.repetition = :repetition") })
public class StateEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2307060250734161242L;

	private Long id;

	private Set<OhioReading> readings;
	private String name;
	private String section;
	private String tireType;
	private String loadnew;
	private String pressure;
	private String speed;
	private String repetition;

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getTireType() {
		return tireType;
	}

	public void setTireType(String tireType) {
		this.tireType = tireType;
	}

	public String getLoadNew() {
		return loadnew;
	}

	public void setLoadNew(String loadNew) {
		this.loadnew = loadNew;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getRepetition() {
		return repetition;
	}

	public void setRepetition(String repetition) {
		this.repetition = repetition;
	}

	public String getSpeed() {
		return speed;
	}

	public void setSpeed(String speed) {
		this.speed = speed;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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
	@JoinTable(name = "state_reading", joinColumns = { @JoinColumn(name = "state_id") }, inverseJoinColumns = @JoinColumn(name = "readings_id"))
	public Set<OhioReading> getReadings() {
		return readings;
	}

	public void setReadings(Set<OhioReading> sections) {
		this.readings = sections;
	}

	public void addSection(OhioReading section) {
		if (getReadings() == null) {
			readings = new HashSet<OhioReading>();
		}
		getReadings().add(section);
	}

	// @Override
	// public int hashCode() {
	// int result;
	// result = (getName()!= null ? getName().hashCode() : 0);
	// return result;
	// }
	//
	// @Override
	// public boolean equals(Object obj) {
	// // TODO Auto-generated method stub
	// return super.equals(obj);
	// }

}
