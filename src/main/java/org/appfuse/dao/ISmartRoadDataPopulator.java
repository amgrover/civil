package org.appfuse.dao;

import java.io.IOException;

public interface ISmartRoadDataPopulator {

	public void populateTestSpeedPressure(String file) throws IOException;

	public void populateTests(String file) throws IOException;

	public void process(String file, String test) throws IOException;

}
