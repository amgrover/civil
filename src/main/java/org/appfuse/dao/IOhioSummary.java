package org.appfuse.dao;

import java.util.List;

import org.appfuse.model.OhioSummary;

public interface IOhioSummary extends GenericDao<OhioSummary, Long> {
        void getData();
        List<String> getDistinctSeasons(String section, String load,
    			String tire, String state, String pressure, String speed);
}
