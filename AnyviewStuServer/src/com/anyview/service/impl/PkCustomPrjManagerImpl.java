package com.anyview.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.codec.pojo.response.CustomProject;
import com.anyview.dao.PkCustomPrjDao;
import com.anyview.service.PkCustomPrjManger;

/**
 * 
 * @author 杨坚新
 *
 */
@Service
public class PkCustomPrjManagerImpl implements PkCustomPrjManger {
	@Autowired
	private PkCustomPrjDao PkCustomPrjDao;

	@Override
	public List<CustomProject> getCustomPrj(int sid) {
		return PkCustomPrjDao.getCustomPrj(sid);
	}

}
