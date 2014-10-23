package org.appfuse.dao;

import java.util.List;

import org.appfuse.model.Tests;

public interface ITestDao extends GenericDao<Tests, Long> {
	public List<String> getDates(String testId);
	public List<String> getSeq(String testId,String date);

}
