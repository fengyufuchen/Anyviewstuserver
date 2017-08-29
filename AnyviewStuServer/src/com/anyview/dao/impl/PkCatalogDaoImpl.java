package com.anyview.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.anyview.codec.pojo.response.CatalogInfo;
import com.anyview.dao.PkCatalogDao;

/**
 * 
 * @author 杨坚新
 *
 */
@Repository
public class PkCatalogDaoImpl extends BaseDaoImpl implements PkCatalogDao {

//	@Override
//	public Map<String, List<CatalogInfo>> getCatalogs(String sid, String cid) {
//		// 查询计划表名和vid
//		String query1 = "select new map(t1.vname as vname,t1.vid as vid) from SchemeTable as t1 where t1.status=2 and t1.kind=0 and t1.course.courseId in ("
//				+ "select t2.course.courseId from ClassCourseTable as t2 where t2.cla.cid=:cid)";
//		// 查询作业计划内容表的信息,并将信息封装到CatalogInfo实例中
//		String query2 = "select new com.anyview.codec.pojo.response.CatalogInfo(t1.problem.pid,t1.vchapName,t1.vpName,t1.startTime,t1.finishTime,t2.eid,t2.score,t2.runResult,t2.runErrCount,t2.cmpCount,t2.cmpRightCount,t2.cmpErrorCount,t2.firstPastTime,t2.lastTime,t2.updateTime) from SchemeContentTable as t1,ExerciseTable as t2 where t1.scheme.vid=? and t1.status=1 and t2.student.sid=? and t2.scheme.vid=? and t2.problem.pid=t1.problem.pid and t2.cla.cid=?";
//		// 该函数返回的值,key:计划表名称,value:包含计划表的题目信息的集合
//		Map<String, List<CatalogInfo>> catalogInfos = new HashMap<>();
//		@SuppressWarnings("unchecked")
//		List<Map> list = getSession().createQuery(query1).setString("cid", cid).list();
//		for (Map map : list) {
//			String vname = (String) map.get("vname");
//			int vid = (int) map.get("vid");
//			List<CatalogInfo> catalogInfoList = getSession().createQuery(query2).setInteger(0, vid).setString(1, sid)
//					.setInteger(2, vid).setString(3, cid).list();
//			catalogInfos.put(vname, catalogInfoList);
//		}
//		return catalogInfos;
//	}

	/**
	 * 获取计划表的vid和vname
	 */
	@Override
	public List<Map<Integer, String>> getVidAndVName(String cid) {
		String query1 = "select new map(t1.vname as vname,t1.vid as vid) from SchemeTable as t1 where t1.status=2 and t1.kind=0 and t1.course.courseId in ("
				+ "select t2.course.courseId from ClassCourseTable as t2 where t2.cla.cid=:cid)";
		List<Map<Integer, String>> list = getSession().createQuery(query1).setString("cid", cid).list();
		return list;
	}

	@Override
	public List<CatalogInfo> getCatalog(Integer vid, String sid, String cid) {
		String query2 = "select new com.anyview.codec.pojo.response.CatalogInfo(t1.problem.pid,t1.vchapName,t1.vpName,t1.startTime,t1.finishTime,t2.eid,t2.score,t2.runResult,t2.runErrCount,t2.cmpCount,t2.cmpRightCount,t2.cmpErrorCount,t2.firstPastTime,t2.lastTime,t2.updateTime) from SchemeContentTable as t1,ExerciseTable as t2 where t1.scheme.vid=? and t1.status=1 and t2.student.sid=? and t2.scheme.vid=? and t2.problem.pid=t1.problem.pid and t2.cla.cid=?";
		List<CatalogInfo> catalogInfoList = getSession().createQuery(query2).setInteger(0, vid).setString(1, sid)
				.setInteger(2, vid).setString(3, cid).list();
		return catalogInfoList;
	}

}
