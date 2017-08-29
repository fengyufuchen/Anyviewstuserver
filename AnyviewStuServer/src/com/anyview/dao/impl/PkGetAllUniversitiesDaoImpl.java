package com.anyview.dao.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.anyview.dao.PkGetAllUniversitiesDao;
import com.anyview.entities.UniversityTable;

/**
 * 
 * @author 吴汪洋
 *
 */
@Service
public class PkGetAllUniversitiesDaoImpl extends BaseDaoImpl implements PkGetAllUniversitiesDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UniversityTable> getAllUniversities() {
		String hql = "from UniversityTable where UnID<>-1";
		return hibernateTemplate.find(hql);
	}
}
