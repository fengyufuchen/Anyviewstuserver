package com.anyview.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.anyview.dao.PkGetClassDao;

/**
 * 
 * @author 杨坚新
 *
 */
@Repository
public class PkGetClassDaoImpl extends BaseDaoImpl implements PkGetClassDao {

	@Override
	public Map<Integer, String> pkGetClasses(int unid, String sno) {
		Map<Integer, String> classes = new HashMap<>();
		String hql = "select new map(cid as cid,cname as cname) from ClassTable where cid in(select cla.cid from ClassStudentTable where student.sid=(select sid from StudentTable where sno=? and university.unID=?))";
		List<Map> list = getSession().createQuery(hql).setString(0, sno).setInteger(1, unid).list();
		for (Map map : list) {
			classes.put((Integer) map.get("cid"), (String) map.get("cname"));
		}
		return classes;
	}
}
