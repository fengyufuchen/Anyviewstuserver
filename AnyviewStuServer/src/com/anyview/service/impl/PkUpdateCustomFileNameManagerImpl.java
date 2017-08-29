package com.anyview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkUpdateCustomFileNameDao;
import com.anyview.service.PkUpdateCustomFileNameManager;

/**
 * 
 * @author 杨坚新
 *
 */
@Service
public class PkUpdateCustomFileNameManagerImpl implements PkUpdateCustomFileNameManager {
	@Autowired
	private PkUpdateCustomFileNameDao pkUpdateCustomFileNameDao;

	@Override
	public boolean updateCustomFileName(int cfID, String cpName) {
		return pkUpdateCustomFileNameDao.updateCustomFileName(cfID, cpName);
	}

}
