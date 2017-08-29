package com.anyview.dao.impl;

import org.springframework.stereotype.Repository;

import com.anyview.dao.PkDeleteCustomFileDao;

/**
 * 
 * @author 杨坚新
 *
 */
@Repository
public class PkDeleteCustomFileDaoImpl extends BaseDaoImpl implements PkDeleteCustomFileDao {

	@Override
	public boolean deleteCustomFile(int cfID) {
		String sql = "delete from customfiletable where CFID=?";
		try {
			getSession().createSQLQuery(sql).setInteger(0, cfID).executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
