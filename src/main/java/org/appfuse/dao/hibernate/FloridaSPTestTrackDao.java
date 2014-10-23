package org.appfuse.dao.hibernate;

import org.appfuse.dao.IFloridaSPTestTrackDao;
import org.appfuse.model.FloridaSPTestTrack;
import org.springframework.stereotype.Repository;

@Repository
public class FloridaSPTestTrackDao extends
		GenericDaoHibernate<FloridaSPTestTrack, Long> implements
		IFloridaSPTestTrackDao {

	public FloridaSPTestTrackDao() {
		super(FloridaSPTestTrack.class);
		// TODO Auto-generated constructor stub
	}

}
