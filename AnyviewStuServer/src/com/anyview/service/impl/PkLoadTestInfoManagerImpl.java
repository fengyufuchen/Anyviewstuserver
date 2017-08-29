package com.anyview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.codec.pojo.response.LoadTestInfo;
import com.anyview.dao.PkLoadTestInfoDao;
import com.anyview.service.PkLoadTestInfoManager;

/**
 * 
 * @author 杨坚新
 * 
 */
@Service
public class PkLoadTestInfoManagerImpl implements PkLoadTestInfoManager {
	@Autowired
	private PkLoadTestInfoDao pkLoadTestInfoDao;

	@Override
	public List<LoadTestInfo> getLoadTestInfo(String cid, String courceID) {
		return pkLoadTestInfoDao.getLoadTestInfo(cid, courceID);
	}

}
