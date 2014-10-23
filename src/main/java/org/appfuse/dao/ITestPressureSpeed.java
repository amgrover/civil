package org.appfuse.dao;

import java.util.List;

import org.appfuse.model.TestSpeedPressure;

public interface ITestPressureSpeed extends GenericDao<TestSpeedPressure, Long> {
	public List<String> getLoad();

	public List<String> getSpeed(String load);

	public List<String> getPressure(String load, String speed);

	public List<String> getTestId(String load, String speed, String pressure);

	public List<String> getDates(String load, String speed, String pressure,
			String testId);
}
