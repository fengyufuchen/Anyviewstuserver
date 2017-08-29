package com.anyview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkDeleteCustomFileDao;
import com.anyview.service.PkDeleteCustomFileManager;

/**
 * 
 * @author 杨坚新
 *
 */
@Service
public class PkDeleteCustomFileManagerImpl implements PkDeleteCustomFileManager {
	@Autowired
	private PkDeleteCustomFileDao pkDeleteCustomFileDao;

	@Override
	public boolean deleteCustomFile(int cfID) {
		return pkDeleteCustomFileDao.deleteCustomFile(cfID);
	}

}
