package com.anyview.dao.impl;

import org.springframework.stereotype.Repository;

import com.anyview.dao.PkProblemDao;
import com.anyview.entities.ProblemTable;

@Repository
public class PkPorblemDaoImpl extends BaseDaoImpl implements PkProblemDao {

	@Override
	public ProblemTable getPContent(String pid) {
		ProblemTable problem = (ProblemTable) getSession().get(ProblemTable.class, Integer.parseInt(pid));
		if (problem != null) {
			return problem;
		} else
			return null;

	}

}
