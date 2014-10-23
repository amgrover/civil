package org.appfuse.dao.hibernate;

import org.appfuse.dao.StateDao;
import org.appfuse.model.State;
import org.springframework.stereotype.Repository;

@Repository
public class StateDaoImpl extends GenericDaoHibernate<State, Long> implements
		StateDao {

	public StateDaoImpl() {
		super(State.class);
		// TODO Auto-generated constructor stub
	}

}
