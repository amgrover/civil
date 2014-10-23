package org.appfuse.dao.hibernate;

import org.appfuse.dao.ITireTypeDao;
import org.appfuse.model.TireType;
import org.springframework.stereotype.Repository;

@Repository
public class TireTypeDaoImpl extends GenericDaoHibernate<TireType, Long>
		implements ITireTypeDao {

	public TireTypeDaoImpl() {
		super(TireType.class);
	}

}
