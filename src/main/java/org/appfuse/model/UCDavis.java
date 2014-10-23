package org.appfuse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class UCDavis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4610218925220349783L;
	private String tirePressure;
	private String loadKip;
	private String testId;
	private String cycles;
	private String sensorType;
	private String sensor;
	private String trafficking;
	private String wheelType;
	private String filePath;
	private String dateTime;
	private Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTirePressure() {
		return tirePressure;
	}

	public void setTirePressure(String tirePressure) {
		this.tirePressure = tirePressure;
	}

	public String getLoadKip() {
		return loadKip;
	}

	public void setLoadKip(String loadKip) {
		this.loadKip = loadKip;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getCycles() {
		return cycles;
	}

	public void setCycles(String cycles) {
		this.cycles = cycles;
	}

	public String getSensorType() {
		return sensorType;
	}

	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}

	public String getSensor() {
		return sensor;
	}

	public void setSensor(String sensor) {
		this.sensor = sensor;
	}

	public String getTrafficking() {
		return trafficking;
	}

	public void setTrafficking(String trafficking) {
		this.trafficking = trafficking;
	}

	public String getWheelType() {
		return wheelType;
	}

	public void setWheelType(String wheelType) {
		this.wheelType = wheelType;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

}
