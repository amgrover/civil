package org.appfuse.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.appfuse.dao.IDavisSummaryDao;
import org.appfuse.model.DavisSummary;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository
public class DavisSummaryDao extends GenericDaoHibernate<DavisSummary, Long>
		implements IDavisSummaryDao {

	public DavisSummaryDao() {
		super(DavisSummary.class);
		// TODO Auto-generated constructor stub
	}

	public List<String> getSensorNames(final String sensorType) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(Name) FROM DavisSummary where Type =:type")
								.setParameter("type", sensorType).list();

						return query;
					}
				});
	}

	public List<String> getTirePressure(final String sensorName,
			final String sensor) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(TirePressure) FROM DavisSummary where Type =:type and Name =:sensor")
								.setParameter("type", sensor)
								.setParameter("sensor", sensorName).list();

						return query;
					}
				});
	}

	public List<String> getLoad(final String sensorType,
			final String sensorName, final String tirePressure) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(LoadKips) FROM DavisSummary where Name =:name and Type =:type and TirePressure=:pressure")
								.setParameter("name", sensorName)
								.setParameter("type", sensorType)
								.setParameter("pressure", tirePressure).list();

						return query;
					}
				});
	}

	public List<String> getWheels(final String sensorType,
			final String sensorName, final String tirePressure,
			final String load) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(NumWheels) FROM DavisSummary where Name =:name and Type =:type and TirePressure=:pressure and LoadKips=:load ")
								.setParameter("name", sensorName)
								.setParameter("type", sensorType)
								.setParameter("pressure", tirePressure)
								.setParameter("load", load).list();

						return query;
					}
				});
	}

	public List<String> getWheelsOffset(final String sensorType,
			final String sensorName, final String tirePressure,
			final String load, final String numOfWheels) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(WheelOffset) FROM DavisSummary where Name =:name and Type =:type and TirePressure=:pressure and LoadKips=:load and NumWheels=:num ")
								.setParameter("name", sensorName)
								.setParameter("type", sensorType)
								.setParameter("pressure", tirePressure)
								.setParameter("load", load)
								.setParameter("num", numOfWheels).list();

						return query;
					}
				});
	}

	public List<DavisSummary> getDavisSummary(final String sensorType,
			final String sensorName, final String tirePressure,
			final String load, final String numOfWheels, final String offset) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<DavisSummary>>() {

					public List<DavisSummary> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<DavisSummary> query = session
								.createSQLQuery(
										"SELECT r FROM DavisSummary r where r.Name =:name and r.Type =:type and r.TirePressure=:pressure and r.LoadKips=:load and r.NumWheels=:num and r.WheelOffset=:offset")
								.setParameter("name", sensorName)
								.setParameter("type", sensorType)
								.setParameter("pressure", tirePressure)
								.setParameter("load", load)
								.setParameter("num", numOfWheels)
								.setParameter("offset", offset).list();

						return query;
					}
				});
	}

}
