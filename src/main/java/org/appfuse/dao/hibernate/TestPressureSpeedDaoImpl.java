package org.appfuse.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.appfuse.dao.ITestPressureSpeed;
import org.appfuse.model.TestSpeedPressure;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository
public class TestPressureSpeedDaoImpl extends
		GenericDaoHibernate<TestSpeedPressure, Long> implements
		ITestPressureSpeed {

	public TestPressureSpeedDaoImpl() {
		super(TestSpeedPressure.class);
		// TODO Auto-generated constructor stub
	}

	public List<String> getLoad() {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(loadNew) FROM TestSpeedPressure")
								.list();

						return query;
					}
				});

	}

	public List<String> getSpeed(final String load) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(speed) FROM TestSpeedPressure WHERE loadNew = :name")
								.setParameter("name", load).list();

						return query;
					}
				});
		// TODO Auto-generated method stub

	}

	public List<String> getPressure(final String load, final String speed) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(pressure) FROM TestSpeedPressure WHERE loadNew = :name and speed = :speed")
								.setParameter("name", load)
								.setParameter("speed", speed).list();

						return query;
					}
				});
	}

	public List<String> getTestId(final String load, final String speed,
			final String pressure) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(testId) FROM TestSpeedPressure WHERE loadNew = :name and speed = :speed and pressure =:pressure")
								.setParameter("name", load)
								.setParameter("speed", speed)
								.setParameter("pressure", pressure).list();

						return query;
					}
				});
	}

	public List<String> getDates(final String load, final String speed,
			final String pressure, final String testId) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(startDate) FROM TestSpeedPressure WHERE loadNew = :name and speed = :speed and pressure =:pressure and testId=:testId")
								.setParameter("name", load)
								.setParameter("speed", speed)
								.setParameter("pressure", pressure)
								.setParameter("testId", testId).list();

						return query;
					}
				});
	}

}
