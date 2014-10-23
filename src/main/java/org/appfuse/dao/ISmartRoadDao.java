package org.appfuse.dao;

import java.util.List;

import org.appfuse.model.SmartRoad;

public interface ISmartRoadDao extends GenericDao<SmartRoad, Long> {

	public List<String> getSections(String date);

}
