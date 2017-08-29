package com.anyview.dao.impl;
/**
 * 
 * @author 李海峰
 */
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.anyview.dao.PkUpdateCmpTimesDao;
import com.anyview.entities.ExerciseTable;

@Repository
public class PkUpdateCmpTimesDaoImpl extends BaseDaoImpl implements PkUpdateCmpTimesDao {
	@SuppressWarnings("unchecked")
	@Override
	public void updateCmpTimesDao(String eid, int cmpcount, int cmprightcount,
			int cmperrorcount) {
		// TODO 自动生成的方法存根
		ExerciseTable exercise=
				(ExerciseTable) getSession().get(ExerciseTable.class, Integer.parseInt(eid));
		exercise.setCmpCount(cmpcount);
		exercise.setCmpRightCount(cmprightcount);
		exercise.setCmpErrorCount(cmperrorcount);
	}

}
