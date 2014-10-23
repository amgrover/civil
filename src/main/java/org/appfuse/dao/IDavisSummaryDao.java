package org.appfuse.dao;

import java.util.List;

import org.appfuse.model.DavisSummary;

public interface IDavisSummaryDao extends GenericDao<DavisSummary, Long> {
	List<String> getSensorNames(String sensorType);

	List<String> getTirePressure(String sensorName, String sensorType);

	List<String> getLoad(String sensorType, String sensorName,
			String tirePressure);

	public List<String> getWheels(final String sensorType,
			final String sensorName, final String tirePressure,
			final String load);

	public List<String> getWheelsOffset(final String sensorType,
			final String sensorName, final String tirePressure,
			final String load, final String numOfWheels);

	public List<DavisSummary> getDavisSummary(final String sensorType,
			final String sensorName, final String tirePressure,
			final String load, final String numOfWheels, final String offset);
}
