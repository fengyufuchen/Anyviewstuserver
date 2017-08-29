package com.anyview.dao.impl;

import org.springframework.stereotype.Repository;

import com.anyview.dao.PkGetExerciseContentDao;
import com.anyview.entities.ExerciseTable;

@Repository
public class PkGetExerciseContentDaoImpl extends BaseDaoImpl implements PkGetExerciseContentDao {

	@Override
	public ExerciseTable getExercise(Integer eid) {
		ExerciseTable exercise = (ExerciseTable) getSession().get(ExerciseTable.class, eid);
		return exercise;
	}

}
