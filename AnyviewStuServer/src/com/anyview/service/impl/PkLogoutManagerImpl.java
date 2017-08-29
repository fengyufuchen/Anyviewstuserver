package com.anyview.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkLogoutDao;
import com.anyview.service.PkLogoutManager;

/**
 * @author 杨坚新
 */
@Service
public class PkLogoutManagerImpl implements PkLogoutManager {
	@Autowired
	private PkLogoutDao pkLogoutDao;

	@Override
	public boolean updateStudentLoginState(String sid) {
		return pkLogoutDao.updateStudentLoginState(sid);
	}

}
