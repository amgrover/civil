package org.appfuse.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.appfuse.dao.IStateEntityDao;
import org.appfuse.model.StateEntity;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class StateEntityDaoImpl extends GenericDaoHibernate<StateEntity, Long>
		implements IStateEntityDao {

	public StateEntityDaoImpl() {
		super(StateEntity.class);
	}

	public List<String> getDistinctSectionName(final String state) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(section) FROM stateentity WHERE name = :name")
								.setParameter("name", state).list();

						return query;
					}
				});

	}

	public List<String> getDistinctTireType(final String section,
			final String state) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(tireType) FROM stateentity WHERE section = :name and name = :state")
								.setParameter("name", section)
								.setParameter("state", state).list();
						return query;
					}
				});

	}

	public List<String> getDistinctLoad(final String section,
			final String tireType, final String state) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(loadNew) FROM stateentity WHERE section = :name and name = :state and tireType = :tire")
								.setParameter("name", section)
								.setParameter("state", state)
								.setParameter("tire", tireType).list();
						return query;
					}
				});

	}

	public List<String> getDistinctPressure(final String section,
			final String load, final String tire, final String state) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(pressure) FROM stateentity WHERE section = :name and name = :state and tireType = :tire and loadNew= :load")
								.setParameter("name", section)
								.setParameter("state", state)
								.setParameter("tire", tire)
								.setParameter("load", load).list();
						return query;
					}

				});
	}

	public List<String> getDistinctSpeed(final String section,
			final String load, final String tire, final String state) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(speed) FROM stateentity WHERE section = :name and name = :state and tireType = :tire and loadNew= :load")
								.setParameter("name", section)
								.setParameter("state", state)
								.setParameter("tire", tire)
								.setParameter("load", load).list();
						return query;
					}
				});
	}

	public List<String> getDistinctRepetition(final String section,
			final String load, final String tire, final String state,
			final String pressure, final String speed) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(repetition) FROM stateentity WHERE section = :name and name = :state and tireType = :tire and loadNew= :load and speed=:speed and pressure = :pressure")
								.setParameter("name", section)
								.setParameter("state", state)
								.setParameter("tire", tire)
								.setParameter("load", load)
								.setParameter("speed", speed)
								.setParameter("pressure", pressure).list();
						return query;
					}
				});
	}

}
