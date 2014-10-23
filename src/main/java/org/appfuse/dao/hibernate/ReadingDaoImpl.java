package org.appfuse.dao.hibernate;

import org.appfuse.dao.IReadingDao;
import org.appfuse.model.Reading;
import org.springframework.stereotype.Repository;

@Repository
public class ReadingDaoImpl extends GenericDaoHibernate<Reading, Long>
		implements IReadingDao {

	public ReadingDaoImpl() {
		super(Reading.class);
		// TODO Auto-generated constructor stub
	}

}
