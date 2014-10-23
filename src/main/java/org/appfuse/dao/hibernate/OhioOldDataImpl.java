package org.appfuse.dao.hibernate;

import org.appfuse.dao.IOhioOld;
import org.appfuse.model.OhioOldData;
import org.springframework.stereotype.Repository;

@Repository
public class OhioOldDataImpl extends GenericDaoHibernate<OhioOldData, Long> implements IOhioOld {

	public OhioOldDataImpl() {
		super(OhioOldData.class);
		// TODO Auto-generated constructor stub
	}

}
