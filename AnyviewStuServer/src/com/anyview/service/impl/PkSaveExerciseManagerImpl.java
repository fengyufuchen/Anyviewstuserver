package com.anyview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkSaveExerciseDao;
import com.anyview.service.PkSaveExerciseManager;
/**
 * 
 * @author 李海峰
 */
@Service
public class PkSaveExerciseManagerImpl implements PkSaveExerciseManager {
	
	@Autowired
	private PkSaveExerciseDao pkSaveExerciseDao;

	@Override
	public void SaveExerciseDao(String eid, String econtent) {
		// TODO 自动生成的方法存根
		pkSaveExerciseDao.SaveExerciseDao(eid, econtent);

	}

}
