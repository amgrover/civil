package org.appfuse.util;

import org.appfuse.dao.IDatabsePopulator;
import org.appfuse.dao.IUCDavisDataPopulator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DatabasePopulation {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext-resources.xml",
				"classpath:/applicationContext-dao.xml",
				"classpath:/applicationContext-service.xml",
				"classpath*:/applicationContext.xml");
		IDatabsePopulator stud = (IDatabsePopulator) context
				.getBean("databasePopulateImpl");
		// stud.populateDatabase();
		// List<String> path = new ArrayList<String>();
		// path.add(args[0]);
		// stud.populateOhio(args[0]);
		IUCDavisDataPopulator dataPopulator = (IUCDavisDataPopulator) context
				.getBean("davisDataPopulatorImpl");
		dataPopulator.populateUCDavis(args[0]);

	}
}
