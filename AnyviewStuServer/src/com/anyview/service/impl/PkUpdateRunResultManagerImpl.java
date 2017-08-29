package com.anyview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.anyview.dao.PkUpdateRunResultDao;
import com.anyview.service.PkUpdateRunResultManager;
/**
 * 
 * @author 李海峰
 */
@Service
public class PkUpdateRunResultManagerImpl implements PkUpdateRunResultManager {

	
	@Autowired
	private PkUpdateRunResultDao  pkUpdateRunResultDao;
	

	@Override
	public void updateRunResult(String eid, int runresult, int runerrcount) {
		// TODO 自动生成的方法存根
     pkUpdateRunResultDao.updateRunResult(eid, runresult,runerrcount);
     
	}

}
