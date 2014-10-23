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
@NamedQueries({ @NamedQuery(name = "findFloridaTestTrack", query = "select r from FloridaSPTestTrack r where r.testType = :testType and sensorType=:sensorType  and r.tireType = :tireType and r.loadKip = :loadKip and r.pressure = :pressure and r.cycle = :cycle and r.repetition = :repetition") })
public class FloridaSPTestTrack implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2307060250734161242L;

	private Long id;
	private Set<FloridaSPReadingTestTrack> floridaSPReadingTestTracks;
	private String sensorType;

	public String getSensorType() {
		return sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	private String testType;
	private String tireType;
	private String loadKip;
	private String pressure;
	private String cycle;
	private String repetition;

	public String getTestType() {
		return testType;
	}

	public void setTestType(String testType) {
		this.testType = testType;
	}

	public String getTireType() {
		return tireType;
	}

	public void setTireType(String tireType) {
		this.tireType = tireType;
	}

	public String getLoadKip() {
		return loadKip;
	}

	public void setLoadKip(String load) {
		this.loadKip = load;
	}

	public String getPressure() {
		return pressure;
	}

	public void setPressure(String pressure) {
		this.pressure = pressure;
	}

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}

	public String getRepetition() {
		return repetition;
	}

	public void setRepetition(String repetition) {
		this.repetition = repetition;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "florida_reading", joinColumns = { @JoinColumn(name = "florida_id") }, inverseJoinColumns = @JoinColumn(name = "readings_id"))
	public Set<FloridaSPReadingTestTrack> getFloridaSPReadingTestTracks() {
		return floridaSPReadingTestTracks;
	}

	public void setFloridaSPReadingTestTracks(
			Set<FloridaSPReadingTestTrack> floridaSPReadingTestTracks) {
		this.floridaSPReadingTestTracks = floridaSPReadingTestTracks;
	}

	public void addReading(FloridaSPReadingTestTrack section) {
		if (getFloridaSPReadingTestTracks() == null) {
			floridaSPReadingTestTracks = new HashSet<FloridaSPReadingTestTrack>();
		}
		getFloridaSPReadingTestTracks().add(section);

	}

	public void setId(Long id) {
		this.id = id;
	}

}
