package com.anyview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkChangePasswordDao;
import com.anyview.dao.PkLoginDao;
import com.anyview.entities.StudentTable;
import com.anyview.service.PkChangePasswordManager;

@Service
public class PkChangePasswordManagerImpl implements PkChangePasswordManager {

	@Autowired
	private PkChangePasswordDao pkChangePasswordDao;
	
	@Override
	public List<StudentTable> getStudentInfo(int Sid) {
		// TODO 自动生成的方法存根
		return pkChangePasswordDao.getStudentInfo(Sid);
	}

	@Override
	public void setnewPassword(int Sid, String NewSPsw) {
		// TODO 自动生成的方法存根
		 pkChangePasswordDao.setnewPassword(Sid, NewSPsw);
	}

}
