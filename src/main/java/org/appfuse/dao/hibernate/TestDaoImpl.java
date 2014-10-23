package org.appfuse.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import org.appfuse.dao.ITestDao;
import org.appfuse.model.Tests;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

@Repository
public class TestDaoImpl extends GenericDaoHibernate<Tests, Long> implements
		ITestDao {

	public TestDaoImpl() {
		super(Tests.class);
		// TODO Auto-generated constructor stub
	}

	public List<String> getDates(final String testId) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(startDate) FROM Tests WHERE testId = :name")
								.setParameter("name", testId).list();

						return query;
					}
				});
	}

	public List<String> getSeq(final String testId, final String date) {
		return this.getHibernateTemplate().executeFind(
				new HibernateCallback<List<String>>() {

					public List<String> doInHibernate(Session session)
							throws HibernateException, SQLException {
						List<String> query = session
								.createSQLQuery(
										"SELECT DISTINCT(testSeqNo) FROM Tests WHERE testId = :name and startDate =:date")
								.setParameter("name", testId)
								.setParameter("date", date).list();

						return query;
					}
				});
	}

}
