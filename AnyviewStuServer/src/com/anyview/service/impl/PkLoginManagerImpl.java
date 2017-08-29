package com.anyview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkLoginDao;
import com.anyview.dao.impl.PkLoginDaoImpl;
import com.anyview.entities.StudentTable;
import com.anyview.service.PkLoginManager;

@Service
public class PkLoginManagerImpl implements PkLoginManager {

	@Autowired
	private PkLoginDao pkLoginDao;

	@Override
	public List<StudentTable> getStudentInfo(String userAccount, int universityID) {
		return pkLoginDao.getStudentInfo(userAccount, universityID);
	}

	@Override
	public void setLoginSuccessStatus(String subscriberAccount, int universityID, String ip, int port) {
		pkLoginDao.setLoginSuccessStatus(subscriberAccount, universityID, ip, port);
	}

	@Override
	public String getUnNameByUnid(int unid) {
		return pkLoginDao.getUnNameByUnid(unid);
	}

	@Override
	public String getCNameByCid(int cid) {
		return pkLoginDao.getCNameByCid(cid);
	}
}
