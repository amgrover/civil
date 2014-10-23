package org.appfuse.util;

import org.appfuse.dao.IDavisSummaryDataPopulator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DavisSummaryDataPopulator {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext-resources.xml",
				"classpath:/applicationContext-dao.xml",
				"classpath:/applicationContext-service.xml",
				"classpath*:/applicationContext.xml");

		IDavisSummaryDataPopulator dataPopulator = (IDavisSummaryDataPopulator) context
				.getBean("davisSummaryDataPopulator");
		dataPopulator.saveData(args[0]);

	}

}