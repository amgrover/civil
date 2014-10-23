package org.appfuse.dao;

import java.util.List;

import org.appfuse.model.UCDavis;

import com.lowagie.tools.split_pdf;

public interface IUCDavisDao extends GenericDao<UCDavis, Long> {

	List<String> getSensorType();

	List<String> getTestIds();

	List<String> getTirePressure(String testId, String sensor);

	List<String> getLoad(String testId, String sensor);

	List<String> getWheelType(String sensor, String testId, String pressure,
			String load);

	List<String> getTrafficking(String sensor, String testId, String pressure,
			String load);

	List<String> getRepetition(String sensor, String testId, String pressure,
			String load, String wheelType, String trafficking);

	List<String> getFileName(String sensor, String testId, String pressure,
			String load, String wheelType, String trafficking, String cycle);

	List<String> getDate();

	List<String> getTemp(String date);
}
