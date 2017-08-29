package com.anyview.dao.impl;

import org.springframework.stereotype.Repository;

import com.anyview.dao.PkUpdateCustomFileNameDao;
import com.anyview.entities.CustomFileTable;

/**
 * 
 * @author 杨坚新
 *
 */
@Repository
public class PkUpdateCustomFileNameDaoImpl extends BaseDaoImpl implements PkUpdateCustomFileNameDao {

	@Override
	public boolean updateCustomFileName(int cfID, String cpName) {
		try {
			CustomFileTable customFile = (CustomFileTable) getSession().get(CustomFileTable.class, cfID);
			customFile.setCfName(cpName);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

}
