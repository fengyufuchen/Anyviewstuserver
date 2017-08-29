package com.anyview.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.anyview.dao.PkChangePasswordDao;
import com.anyview.entities.StudentTable;
@Repository
public class PkChangePasswordDaoImpl extends BaseDaoImpl implements PkChangePasswordDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentTable> getStudentInfo(int Sid) {
		String hql = "from StudentTable where SID=?";
		List<StudentTable> list = 
				hibernateTemplate.find(hql, new Object[]{Sid});
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setnewPassword(int Sid, String NewSPsw) {
		final String hql = "update studenttable set SPsw=? "+ "where SID=? ";
		
		Session session = getSession();
		Query query = session.createSQLQuery(hql);
		query.setParameter(0, NewSPsw)
			.setParameter(1, Sid)
			.executeUpdate();
	}

	}


