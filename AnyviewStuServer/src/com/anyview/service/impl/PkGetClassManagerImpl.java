package com.anyview.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.dao.PkGetClassDao;
import com.anyview.service.PkGetClassManager;

@Service
public class PkGetClassManagerImpl implements PkGetClassManager {
	@Autowired
	private PkGetClassDao pkGetClassDao;

	@Override
	public Map<Integer, String> pkGetClasses(int unid, String sno) {
		return pkGetClassDao.pkGetClasses(unid, sno);
	}

}
