package org.appfuse.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;

import org.appfuse.dao.IOhioSummary;
import org.appfuse.model.OhioSummary;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository
public class OhioSummaryDao extends GenericDaoHibernate<OhioSummary, Long>
		implements IOhioSummary {

	public OhioSummaryDao() {
		super(OhioSummary.class);
		// TODO Auto-generated constructor stub
	}

	public void getData() {
		org.hibernate.Query query = getSessionFactory().openSession()
				.createQuery("from OhioSummary where name = :name");
		query.setParameter("name", "maxresponses");
		List list = query.list();
		List list2 = getAll();
		System.out.println();

	}

	public List<String> getDistinctSeasons(final String section, final String load,
			final String tire, final String state, final String pressure, final String speed) {

		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(season) FROM ohiosummary WHERE section = :name and name = :state and tireType = :tire and loadNew= :load and speed=:speed and pressure = :pressure")
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
