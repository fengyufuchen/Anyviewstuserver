package com.anyview.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.anyview.codec.pojo.response.CatalogInfo;
import com.anyview.codec.pojo.response.LoadTestInfo;
import com.anyview.dao.PkLoadTestInfoDao;

@Repository
public class PkLoadTestInfoDaoImpl extends BaseDaoImpl implements PkLoadTestInfoDao {

	@Override
	public List<LoadTestInfo> getLoadTestInfo(String cid, String courceID) {

		// 返回的结果
		List<LoadTestInfo> result = new ArrayList<>();
		// 查询考试表的基本信息
		String query1 = "select new Map(epName as epName,scheme.vid as vid,duration as duration,startTime as startTime) from ExamPlanTable where cla.cid=? and course.courseId=? and Status=2";
		// 查询作业计划内容表的信息
		String query2 = "select new com.anyview.codec.pojo.response.CatalogInfo(t.problem.pid,t.vchapName,t.vpName,t.score,t.startTime,t.finishTime,t.updateTime) from SchemeContentTable as t where t.scheme.vid=? and t.status=1";
		// 存储考试的基本信息
		List<Map> map = getSession().createQuery(query1).setString(0, cid).setString(1, courceID).list();
		for (int i = 0; i < map.size(); i++) {
			// 考试对应的计划表
			List<CatalogInfo> list = getSession().createQuery(query2).setInteger(0, (Integer) map.get(i).get("vid"))
					.list();
			String epName = (String) (map.get(i).get("epName"));
			int duration = (int) (map.get(i).get("duration"));
			Date startTime = (Date) (map.get(i).get("startTime"));
			LoadTestInfo loadTestInfo = new LoadTestInfo(epName, duration, startTime, list);
			result.add(loadTestInfo);
		}
		System.out.println(result);
		return result;
	}

}
