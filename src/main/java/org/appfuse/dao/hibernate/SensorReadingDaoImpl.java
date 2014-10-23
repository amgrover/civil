package org.appfuse.dao.hibernate;

import org.appfuse.dao.ISensorReadingDao;
import org.appfuse.model.SensorReading;
import org.springframework.stereotype.Repository;

@Repository
public class SensorReadingDaoImpl extends
		GenericDaoHibernate<SensorReading, Long> implements ISensorReadingDao {

	public SensorReadingDaoImpl() {
		super(SensorReading.class);
		// TODO Auto-generated constructor stub
	}

}
