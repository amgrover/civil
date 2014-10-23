package org.appfuse.util;

import org.appfuse.dao.IDavisSummaryDataPopulator;
import org.appfuse.dao.IOhioOldService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class OhioOldDataPopulator {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext-resources.xml",
				"classpath:/applicationContext-dao.xml",
				"classpath:/applicationContext-service.xml",
				"classpath*:/applicationContext.xml");

		IOhioOldService dataPopulator = (IOhioOldService) context
				.getBean("ohioOldServiceImpl");
		dataPopulator.process(args[0]);

	}

}
