package org.appfuse.dao.hibernate;

import org.appfuse.dao.IRepetitionDao;
import org.appfuse.model.Repetition;
import org.springframework.stereotype.Repository;

@Repository
public class RepetitionDaoImpl extends GenericDaoHibernate<Repetition, Long>
		implements IRepetitionDao {

	public RepetitionDaoImpl() {
		super(Repetition.class);
		// TODO Auto-generated constructor stub
	}

}
