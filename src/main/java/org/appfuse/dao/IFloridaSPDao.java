package org.appfuse.dao;

import java.util.List;

import org.appfuse.model.FloridaSP;
import org.appfuse.model.FloridaSPTestTrack;

public interface IFloridaSPDao extends GenericDao<FloridaSPTestTrack, Long> {

	public List<String> getTireType(String test, final String sensorType);

	public List<String> getLoad(final String test, final String tireType,
			final String sensorType);

	public List<String> getPressure(final String test, final String tireType,
			final String load, final String sensorType);

	public List<String> getCycle(final String test, final String tireType,
			final String load, final String pressure, final String sensorType);

	public List<String> getRepetition(final String test, final String tireType,
			final String load, final String pressure, final String cycle,
			final String sensorType);
}
