package org.appfuse.dao;

import java.util.List;

import org.appfuse.model.FloridaSPSummary;

public interface IFloridaSummaryDao extends GenericDao<FloridaSPSummary, Long> {
	public List<String> getRepetition(final String test, final String tireType,
			final String load, final String pressure, final String cycle,
			final String sensorType,final String responseType);
}
