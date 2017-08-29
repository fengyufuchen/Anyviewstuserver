package com.anyview.dao.impl;

import org.springframework.stereotype.Repository;

import com.anyview.dao.PkUpdateCustomPrjNameDao;
import com.anyview.entities.CustomPrjTable;

/**
 * 
 * @author 杨坚新
 *
 */
@Repository
public class PkUpdateCustomPrjNameDaoImpl extends BaseDaoImpl implements PkUpdateCustomPrjNameDao {

	@Override
	public boolean updateCustomPrjName(int cpID, String cpName) {
		try {
			CustomPrjTable customPrj = (CustomPrjTable) getSession().get(CustomPrjTable.class, cpID);
			customPrj.setCpName(cpName);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
