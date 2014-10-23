package org.appfuse.dao.hibernate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.appfuse.dao.ISmartRoadDao;
import org.appfuse.model.SmartRoad;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository
public class SmartRoadDaoImpl extends GenericDaoHibernate<SmartRoad, Long>
		implements ISmartRoadDao {

	public SmartRoadDaoImpl() {
		super(SmartRoad.class);
	}

	public List<String> getSections(final String seqNo) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(section) FROM SmartRoad WHERE resp_trig_time like :name")
								.setParameter("name", seqNo).list();

						return query;
					}
				});
	}

}
