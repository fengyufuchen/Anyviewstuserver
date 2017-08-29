package com.anyview.dao.impl;

import org.springframework.stereotype.Repository;

import com.anyview.dao.PkDeleteCustomPrjDao;

/**
 * 
 * @author 杨坚新
 *
 */
@Repository
public class PkDeleteCustomPrjDaoImpl extends BaseDaoImpl implements PkDeleteCustomPrjDao {

	@Override
	public boolean deleteCustomPrj(int cpID) {
		// 删除文件
		String deleteFile = "delete from customfiletable where CPID in(select CPID from customprjtable where ParentID=?)";
		// 删除项目
		String deletePrj = "delete from customprjtable where CPID=? or ParentID=?";
		try {
			// 删除文件
			getSession().createSQLQuery(deleteFile).setInteger(0, cpID).executeUpdate();
			// 删除项目
			getSession().createSQLQuery(deletePrj).setInteger(0, cpID).setInteger(1, cpID).executeUpdate();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
