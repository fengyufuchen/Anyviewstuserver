package com.anyview.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkAddCustomPrjDao;
import com.anyview.service.PkAddCustomPrjManager;

/**
 * 
 * 
 * @author 杨坚新
 *
 */
@Service
public class PkAddCustomPrjManagerImpl implements PkAddCustomPrjManager {
	@Autowired
	private PkAddCustomPrjDao manager;

	@Override
	public Map<String, Integer> addCustomPrj(String cpName, int sid, int courseID) {
		// TODO Auto-generated method stub
		return manager.addCustomPrj(cpName, sid, courseID);
	}

}
