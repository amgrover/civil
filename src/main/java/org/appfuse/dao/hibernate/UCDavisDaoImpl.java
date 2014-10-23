package org.appfuse.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.appfuse.dao.IUCDavisDao;
import org.appfuse.model.UCDavis;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository
public class UCDavisDaoImpl extends GenericDaoHibernate<UCDavis, Long>
		implements IUCDavisDao {

	public UCDavisDaoImpl() {
		super(UCDavis.class);
		// TODO Auto-generated constructor stub
	}

	public List<String> getSensorType() {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session.createSQLQuery(
								"SELECT DISTINCT(sensor) FROM UCDavis").list();

						return query;
					}
				});
	}

	public List<String> getTestIds() {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session.createSQLQuery(
								"SELECT DISTINCT(testId) FROM UCDavis").list();

						return query;
					}
				});
	}

	public List<String> getTirePressure(final String testId, final String sensor) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(tirePressure) FROM UCDavis where testId =:testId and sensor =:sensor")
								.setParameter("testId", testId)
								.setParameter("sensor", sensor).list();

						return query;
					}
				});
	}

	public List<String> getLoad(final String testId, final String sensor) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(loadKip) FROM UCDavis where testId =:testId and sensor =:sensor")
								.setParameter("testId", testId)
								.setParameter("sensor", sensor).list();

						return query;
					}
				});
	}

	public List<String> getWheelType(final String sensor, final String testId,
			final String pressure, final String load) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(wheelType) FROM UCDavis where testId =:testId and sensor =:sensor and tirePressure=:pressure and loadKip=:load")
								.setParameter("testId", testId)
								.setParameter("sensor", sensor)
								.setParameter("load", load)
								.setParameter("pressure", pressure).list();

						return query;
					}
				});
	}

	public List<String> getTrafficking(final String sensor,
			final String testId, final String pressure, final String load) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(trafficking) FROM UCDavis where testId =:testId and sensor =:sensor and tirePressure=:pressure and loadKip=:load")
								.setParameter("testId", testId)
								.setParameter("sensor", sensor)
								.setParameter("load", load)
								.setParameter("pressure", pressure).list();

						return query;
					}
				});
	}

	public List<String> getRepetition(final String sensor, final String testId,
			final String pressure, final String load, final String wheelType,
			final String trafficking) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(cycles) FROM UCDavis where testId =:testId and sensor =:sensor and tirePressure=:pressure and loadKip=:load and wheelType=:wheelType and trafficking=:trafficking")
								.setParameter("testId", testId)
								.setParameter("sensor", sensor)
								.setParameter("load", load)
								.setParameter("pressure", pressure)
								.setParameter("wheelType", wheelType)
								.setParameter("trafficking", trafficking)
								.list();

						return query;
					}
				});
	}

	public List<String> getFileName(final String sensor, final String testId,
			final String pressure, final String load, final String wheelType,
			final String trafficking, final String cycle) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(filePath) FROM UCDavis where testId =:testId and sensor =:sensor and tirePressure=:pressure and loadKip=:load and wheelType=:wheelType and trafficking=:trafficking and cycles=:cycle")
								.setParameter("testId", testId)
								.setParameter("sensor", sensor)
								.setParameter("load", load)
								.setParameter("pressure", pressure)
								.setParameter("wheelType", wheelType)
								.setParameter("trafficking", trafficking)
								.setParameter("cycle", cycle).list();

						return query;
					}
				});
	}

	public List<String> getDate() {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(dateTime) FROM UCDavis where sensorType=:temp")
								.setParameter("temp", "TEMP").list();

						return query;
					}
				});
	}

	public List<String> getTemp(final String date) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(filePath) FROM UCDavis where sensorType=:temp and dateTime=:date")
								.setParameter("temp", "TEMP")
								.setParameter("date", date).list();

						return query;
					}
				});
	}
}
