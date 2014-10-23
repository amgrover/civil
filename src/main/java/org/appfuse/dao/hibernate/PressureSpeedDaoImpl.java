package org.appfuse.dao.hibernate;

import org.appfuse.dao.IPressureDao;
import org.appfuse.model.PressureSpeed;
import org.springframework.stereotype.Repository;

@Repository
public class PressureSpeedDaoImpl extends
		GenericDaoHibernate<PressureSpeed, Long> implements IPressureDao {

	public PressureSpeedDaoImpl() {
		super(PressureSpeed.class);
		// TODO Auto-generated constructor stub
	}

}
