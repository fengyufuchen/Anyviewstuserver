package com.anyview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkAddCustomFileDao;
import com.anyview.service.PkAddCustomFileManager;

/**
 * 
 * 
 * @author 杨坚新
 *
 */
@Service
public class PkAddCustomFileManagerImpl implements PkAddCustomFileManager {
	@Autowired
	private PkAddCustomFileDao pkAddCustomFileDao;

	@Override
	public int addCustomFile(int cpID, String cfName, String content) {
		return pkAddCustomFileDao.addCustomFile(cpID, cfName, content);
	}

}
