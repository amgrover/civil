package org.appfuse.util;

import org.appfuse.dao.IFloridaSPTestTrackPopulator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FloridaSPUtility {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"classpath:/applicationContext-resources.xml",
				"classpath:/applicationContext-dao.xml",
				"classpath:/applicationContext-service.xml",
				"classpath*:/applicationContext.xml");
		// IFloridaSPDaoPopulator stud = (IFloridaSPDaoPopulator) context
		// .getBean("floridaSPDaoPopulator");
		IFloridaSPTestTrackPopulator stud = (IFloridaSPTestTrackPopulator) context
				.getBean("floridaSPTestTrackPopulator");
		stud.save(args[0], "Test Track");

	}
}
