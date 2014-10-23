package org.appfuse.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "findDavisSummary", query = "select r from DavisSummary r where r.name =:name and r.type =:type and r.tirePressure=:pressure and r.loadKips=:load and r.numWheels=:num and r.wheelOffset=:offset"),
		@NamedQuery(name = "findDavisSummaryAll", query = "select r from DavisSummary r where  r.type =:type") })
public class DavisSummary implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2547367884594738007L;
	private Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String SectionCode;
	private String Type;
	private String ReadingTime;
	private String RepeatTime;
	private String Repetition;
	private String Instrument;
	private String Repeated;
	private String Name;
	private String DataID;
	private String Suspect;
	private String LoadDefinition;
	private String TestDirection;
	private String Reference;
	private String Valley;
	private String Peak;
	private String ReadingRep;
	private String Station;
	private String MeasuredLoad;
	private String TirePressures;
	private String MovingMode;
	private String TestLoad;
	private String TargetTemp;
	private String CarriagePosYMin;
	private String CarriagePosYMax;
	private String StartRepetition;
	private String NumWheels;
	private String TirePressure;
	private String LoadKips;
	private String WheelOffset;

	public String getSectionCode() {
		return SectionCode;
	}

	public void setSectionCode(String sectionCode) {
		SectionCode = sectionCode;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getReadingTime() {
		return ReadingTime;
	}

	public void setReadingTime(String readingTime) {
		ReadingTime = readingTime;
	}

	public String getRepeatTime() {
		return RepeatTime;
	}

	public void setRepeatTime(String repeatTime) {
		RepeatTime = repeatTime;
	}

	public String getRepetition() {
		return Repetition;
	}

	public void setRepetition(String repetition) {
		Repetition = repetition;
	}

	public String getInstrument() {
		return Instrument;
	}

	public void setInstrument(String instrument) {
		Instrument = instrument;
	}

	public String getRepeated() {
		return Repeated;
	}

	public void setRepeated(String repeat) {
		Repeated = repeat;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDataID() {
		return DataID;
	}

	public void setDataID(String dataID) {
		DataID = dataID;
	}

	public String getSuspect() {
		return Suspect;
	}

	public void setSuspect(String suspect) {
		Suspect = suspect;
	}

	public String getLoadDefinition() {
		return LoadDefinition;
	}

	public void setLoadDefinition(String loadDefinition) {
		LoadDefinition = loadDefinition;
	}

	public String getTestDirection() {
		return TestDirection;
	}

	public void setTestDirection(String testDirection) {
		TestDirection = testDirection;
	}

	public String getReference() {
		return Reference;
	}

	public void setReference(String reference) {
		Reference = reference;
	}

	public String getValley() {
		return Valley;
	}

	public void setValley(String valley) {
		Valley = valley;
	}

	public String getPeak() {
		return Peak;
	}

	public void setPeak(String peak) {
		Peak = peak;
	}

	public String getReadingRep() {
		return ReadingRep;
	}

	public void setReadingRep(String readingRep) {
		ReadingRep = readingRep;
	}

	public String getStation() {
		return Station;
	}

	public void setStation(String station) {
		Station = station;
	}

	public String getMeasuredLoad() {
		return MeasuredLoad;
	}

	public void setMeasuredLoad(String measuredLoad) {
		MeasuredLoad = measuredLoad;
	}

	public String getTirePressures() {
		return TirePressures;
	}

	public void setTirePressures(String tirePressures) {
		TirePressures = tirePressures;
	}

	public String getMovingMode() {
		return MovingMode;
	}

	public void setMovingMode(String movingMode) {
		MovingMode = movingMode;
	}

	public String getTestLoad() {
		return TestLoad;
	}

	public void setTestLoad(String testLoad) {
		TestLoad = testLoad;
	}

	public String getTargetTemp() {
		return TargetTemp;
	}

	public void setTargetTemp(String targetTemp) {
		TargetTemp = targetTemp;
	}

	public String getCarriagePosYMin() {
		return CarriagePosYMin;
	}

	public void setCarriagePosYMin(String carriagePosYMin) {
		CarriagePosYMin = carriagePosYMin;
	}

	public String getCarriagePosYMax() {
		return CarriagePosYMax;
	}

	public void setCarriagePosYMax(String carriagePosYMax) {
		CarriagePosYMax = carriagePosYMax;
	}

	public String getStartRepetition() {
		return StartRepetition;
	}

	public void setStartRepetition(String startRepetition) {
		StartRepetition = startRepetition;
	}

	public String getNumWheels() {
		return NumWheels;
	}

	public void setNumWheels(String numWheels) {
		NumWheels = numWheels;
	}

	public String getTirePressure() {
		return TirePressure;
	}

	public void setTirePressure(String tirePressure) {
		TirePressure = tirePressure;
	}

	public String getLoadKips() {
		return LoadKips;
	}

	public void setLoadKips(String loadKips) {
		LoadKips = loadKips;
	}

	public String getWheelOffset() {
		return WheelOffset;
	}

	public void setWheelOffset(String wheelOffset) {
		WheelOffset = wheelOffset;
	}

}
