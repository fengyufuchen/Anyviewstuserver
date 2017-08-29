package com.anyview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.codec.pojo.response.PkProblemResponse;
import com.anyview.dao.PkGetExerciseContentDao;
import com.anyview.entities.ExerciseTable;
import com.anyview.entities.ProblemTable;
import com.anyview.service.PkGetExerciseContentManager;

@Service
public class PkGetExerciseContentManagerImpl implements PkGetExerciseContentManager {
	@Autowired
	private PkGetExerciseContentDao pkGetExerciseContentDao;


	@Override
	public ExerciseTable getExercise(Integer eid) {
		return pkGetExerciseContentDao.getExercise(eid);
	}



}
