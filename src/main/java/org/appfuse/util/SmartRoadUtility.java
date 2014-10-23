package org.appfuse.util;

import java.io.IOException;

import org.appfuse.dao.IDavisSummaryDataPopulator;
import org.appfuse.dao.ISmartRoadDataPopulator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SmartRoadUtility {
	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext-resources.xml",
				"classpath:/applicationContext-dao.xml",
				"classpath:/applicationContext-service.xml",
				"classpath*:/applicationContext.xml");

		ISmartRoadDataPopulator dataPopulator = (ISmartRoadDataPopulator) context
				.getBean("smartRoadDataPopulator");
		dataPopulator.process(args[0], "");

	}

}
