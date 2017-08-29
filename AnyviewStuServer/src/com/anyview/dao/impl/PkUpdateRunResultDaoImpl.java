package com.anyview.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.anyview.dao.PkUpdateRunResultDao;
import com.anyview.entities.ExerciseTable;

/**
 * 
 * @author 李海峰
 */

@Repository
public class PkUpdateRunResultDaoImpl extends BaseDaoImpl implements PkUpdateRunResultDao {
	


	@Override
	public void updateRunResult(String eid, int runresult, int runerrcount) {
		// TODO 自动生成的方法存根
		ExerciseTable exercise=
				(ExerciseTable) getSession().get(ExerciseTable.class, Integer.parseInt(eid));
		exercise.setRunResult(runresult);
		exercise.setRunErrCount(runerrcount);
	}}
