package org.appfuse.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.appfuse.dao.IFloridaSummaryDao;
import org.appfuse.model.FloridaSPSummary;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository
public class FloridaSPSummaryDao extends
		GenericDaoHibernate<FloridaSPSummary, Long> implements
		IFloridaSummaryDao {

	public FloridaSPSummaryDao() {
		super(FloridaSPSummary.class);
		// TODO Auto-generated constructor stub
	}

	public List<String> getRepetition(final String test, final String tireType,
			final String load, final String pressure, final String cycle,
			final String sensorType, final String responseType) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(repetition) FROM FloridaSPSummary WHERE testType = :testType and tireType= :tireType and loadKip=:load and pressure=:pressure and cycle=:cycle and sensorType=:sensorType and responseType=:responseType ")
								.setParameter("testType", test)
								.setParameter("tireType", tireType)
								.setParameter("load", load)
								.setParameter("pressure", pressure)
								.setParameter("cycle", cycle)
								.setParameter("sensorType", sensorType)
								.setParameter("responseType", responseType)
								.list();
						return query;
					}
				});
	}

}
