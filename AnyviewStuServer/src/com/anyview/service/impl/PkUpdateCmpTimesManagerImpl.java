package com.anyview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkUpdateCmpTimesDao;
import com.anyview.service.PkUpdateCmpTimesManager;
/**
 * 
 * @author 李海峰
 */
@Service
public class PkUpdateCmpTimesManagerImpl implements PkUpdateCmpTimesManager {

	
	@Autowired
	private PkUpdateCmpTimesDao  pkUpdateCmpTimesDao;
	
	@Override
	public void updateCmpTimesDao(String eid, int cmpcount, int cmprightcount,
			int cmperrorcount) {
		// TODO 自动生成的方法存根
		pkUpdateCmpTimesDao.updateCmpTimesDao(eid, cmpcount, cmprightcount, cmperrorcount);
	}

}
