package com.anyview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkUpdateCustomFileContentDao;
import com.anyview.service.PkUpdateCustomFileContentManager;

/**
 * 
 * @author 杨坚新
 *
 */
@Service
public class PkUpdateCustomFileContentManagerImpl implements PkUpdateCustomFileContentManager {
	@Autowired
	private PkUpdateCustomFileContentDao pkUpdateCustomFileDao;

	@Override
	public boolean updateCustomFileResult(int cfID, String content) {
		return pkUpdateCustomFileDao.updateCustomFileResult(cfID, content);
	}

}
