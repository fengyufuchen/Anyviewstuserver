package com.anyview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkUpdateCustomPrjNameDao;
import com.anyview.service.PkUpdateCustomPrjNameManager;

/**
 * 
 * @author 杨坚新
 *
 */
@Service
public class PkUpdateCustomPrjNameManagerImpl implements PkUpdateCustomPrjNameManager {
	@Autowired
	private PkUpdateCustomPrjNameDao pkUpdateCustomPrjNameDao;

	@Override
	public boolean updateCustomPrjName(int cpID, String cpName) {
		return pkUpdateCustomPrjNameDao.updateCustomPrjName(cpID, cpName);
	}

}
