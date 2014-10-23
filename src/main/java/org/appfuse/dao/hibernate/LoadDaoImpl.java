package org.appfuse.dao.hibernate;

import org.appfuse.dao.ILoadDao;
import org.appfuse.model.Load;
import org.springframework.stereotype.Repository;

@Repository
public class LoadDaoImpl extends GenericDaoHibernate<Load, Long> implements
		ILoadDao {

	public LoadDaoImpl() {
		super(Load.class);
		// TODO Auto-generated constructor stub
	}

}
