package com.anyview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkGetAllUniversitiesDao;
import com.anyview.entities.UniversityTable;
import com.anyview.service.PkGetAllUniversitiesManager;

@Service
public class PkGetAllUniversitiesManagerImpl implements PkGetAllUniversitiesManager{
	
	@Autowired
	private PkGetAllUniversitiesDao pkGetAllUniversitiesDao;
	
	@Override
	public List<UniversityTable> getAllUniversities() {
		return pkGetAllUniversitiesDao.getAllUniversities();		
	}
}
