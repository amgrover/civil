package org.appfuse.dao.hibernate;

import org.appfuse.dao.ISectionDao;
import org.appfuse.model.Section;
import org.springframework.stereotype.Repository;

@Repository
public class SectionDao extends GenericDaoHibernate<Section, Long> implements
		ISectionDao {

	public SectionDao() {
		super(Section.class);
		// TODO Auto-generated constructor stub
	}

	
}
