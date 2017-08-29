package com.anyview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkProblemDao;
import com.anyview.entities.ProblemTable;
import com.anyview.service.PkProblemManager;

@Service
public class PkProblemManagerImpl implements PkProblemManager {
	@Autowired
	private PkProblemDao pkProblemDao;

	@Override
	public ProblemTable getPContent(String pid) {
		return pkProblemDao.getPContent(pid);
	}
}
