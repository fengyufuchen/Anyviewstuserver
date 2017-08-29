package com.anyview.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.anyview.dao.PkSaveExerciseDao;
import com.anyview.entities.ExerciseTable;
import com.anyview.entities.ProblemTable;
/**
 * 
 * @author 李海峰
 */

@Repository
public class PkSaveExerciseDaoImpl extends BaseDaoImpl implements PkSaveExerciseDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public void SaveExerciseDao(String eid, String econtent) {
	ExerciseTable exercise=
				(ExerciseTable) getSession().get(ExerciseTable.class, Integer.parseInt(eid));
		exercise.setEcontent(econtent);
		
	}

}
