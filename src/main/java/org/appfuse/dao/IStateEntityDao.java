package org.appfuse.dao;

import java.util.List;

import org.appfuse.model.StateEntity;

public interface IStateEntityDao extends GenericDao<StateEntity, Long> {

	List<String> getDistinctSectionName(String state);

	List<String> getDistinctTireType(String section, String state);

	List<String> getDistinctLoad(String section, String tireType, String state);

	List<String> getDistinctPressure(String section, String load, String tire,
			String state);

	List<String> getDistinctSpeed(String section, String load, String tire,
			String state);

	List<String> getDistinctRepetition(String section, String load,
			String tire, String state, String pressure, String speed);

}
