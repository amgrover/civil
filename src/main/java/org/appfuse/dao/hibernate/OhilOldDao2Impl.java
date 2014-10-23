package org.appfuse.dao.hibernate;

import org.appfuse.dao.IOhioOld2;
import org.appfuse.model.OhioOldData2;
import org.springframework.stereotype.Repository;
@Repository
public class OhilOldDao2Impl extends GenericDaoHibernate<OhioOldData2, Long>
		implements IOhioOld2 {

	public OhilOldDao2Impl() {
		super(OhioOldData2.class);
		// TODO Auto-generated constructor stub
	}

}
