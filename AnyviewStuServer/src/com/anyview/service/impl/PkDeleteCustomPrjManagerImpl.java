package com.anyview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkDeleteCustomPrjDao;
import com.anyview.service.PkDeleteCustomPrjManager;

/**
 * 
 * @author 杨坚新
 *
 */
@Service
public class PkDeleteCustomPrjManagerImpl implements PkDeleteCustomPrjManager {
	@Autowired
	private PkDeleteCustomPrjDao deleteCustomPrjDao;

	@Override
	public boolean deleteCustomPrj(int cpID) {
		return deleteCustomPrjDao.deleteCustomPrj(cpID);
	}

}
