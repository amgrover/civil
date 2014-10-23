package org.appfuse.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.appfuse.dao.IFloridaSPDao;
import org.appfuse.model.FloridaSP;
import org.appfuse.model.FloridaSPTestTrack;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FloridaSPDao extends GenericDaoHibernate<FloridaSPTestTrack, Long>
		implements IFloridaSPDao {

	public FloridaSPDao() {
		super(FloridaSPTestTrack.class);
		// TODO Auto-generated constructor stub
	}

	public List<String> getTireType(final String test, final String sensorType) {
	
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(tireType) FROM FloridaSPTestTrack WHERE testType = :testType and sensorType=:sensorType ")
								.setParameter("testType", test)
								.setParameter("sensorType", sensorType).list();
						return query;
					}
				});
	}

	public List<String> getLoad(final String test, final String tireType,
			final String sensorType) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(loadKip) FROM FloridaSPTestTrack WHERE testType = :testType and tireType= :tireType and sensorType=:sensorType  ")
								.setParameter("testType", test)
								.setParameter("tireType", tireType)
								.setParameter("sensorType", sensorType).list();
						return query;
					}
				});
	}

	public List<String> getPressure(final String test, final String tireType,
			final String load, final String sensorType) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(pressure) FROM FloridaSPTestTrack WHERE testType = :testType and tireType= :tireType and loadKip=:load and sensorType=:sensorType ")
								.setParameter("testType", test)
								.setParameter("tireType", tireType)
								.setParameter("load", load)
								.setParameter("sensorType", sensorType).list();
						return query;
					}
				});
	}

	public List<String> getCycle(final String test, final String tireType,
			final String load, final String pressure, final String sensorType) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(cycle) FROM FloridaSPTestTrack WHERE testType = :testType and tireType= :tireType and loadKip=:load and pressure=:pressure and sensorType=:sensorType ")
								.setParameter("testType", test)
								.setParameter("tireType", tireType)
								.setParameter("load", load)
								.setParameter("pressure", pressure)
								.setParameter("sensorType", sensorType).list();
						return query;
					}
				});
	}

	public List<String> getRepetition(final String test, final String tireType,
			final String load, final String pressure, final String cycle,
			final String sensorType) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(repetition) FROM FloridaSPTestTrack WHERE testType = :testType and tireType= :tireType and loadKip=:load and pressure=:pressure and cycle=:cycle and sensorType=:sensorType ")
								.setParameter("testType", test)
								.setParameter("tireType", tireType)
								.setParameter("load", load)
								.setParameter("pressure", pressure)
								.setParameter("cycle", cycle)
								.setParameter("sensorType", sensorType).list();
						return query;
					}
				});
	}
}
