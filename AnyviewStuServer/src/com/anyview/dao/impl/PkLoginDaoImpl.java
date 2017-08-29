package com.anyview.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.anyview.dao.PkLoginDao;
import com.anyview.entities.ClassTable;
import com.anyview.entities.StudentTable;
import com.anyview.entities.UniversityTable;

@Repository
public class PkLoginDaoImpl extends BaseDaoImpl implements PkLoginDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentTable> getStudentInfo(String userAccount, int universityID) {
		String hql = "from StudentTable where Sno=? and UnID=?";
		List<StudentTable> list = hibernateTemplate.find(hql, new Object[] { userAccount, universityID });
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setLoginSuccessStatus(String subscriberAccount, int universityID, String ip, int port) {

		final String sql = "update studenttable set LoginStatus=?,LogTime=?,LogIp=?,LogPort=? "
				+ "where Sno=? and UnID=?";

		Session session = getSession();
		Query query = session.createSQLQuery(sql);
		query.setParameter(0, 1).setParameter(1, new Timestamp(System.currentTimeMillis())).setParameter(2, ip)
				.setParameter(3, port).setParameter(4, subscriberAccount).setParameter(5, universityID).executeUpdate();
	}

	@Override
	public String getUnNameByUnid(int unid) {
		UniversityTable university = (UniversityTable) getSession().get(UniversityTable.class, unid);
		return university.getUnName();
	}

	@Override
	public String getCNameByCid(int cid) {
		ClassTable clas = (ClassTable) getSession().get(ClassTable.class, cid);
		return clas.getCname();
	}

}
