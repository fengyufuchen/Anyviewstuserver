package com.anyview.dao.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.anyview.dao.PkAddCustomPrjDao;
import com.anyview.entities.CourseTable;
import com.anyview.entities.CustomPrjTable;
import com.anyview.entities.StudentTable;

/**
 * 
 * 
 * @author 杨坚新
 *
 */
@Repository
public class PkAddCustomPrjDaoImpl extends BaseDaoImpl implements PkAddCustomPrjDao {

	@Override
	public Map<String, Integer> addCustomPrj(String cpName, int sid, int courseID) {
		// 存储项目ID,源文件ID,头文件ID
		Map<String, Integer> idMap = new HashMap<>();
		// 新建项目文件夹
		int cpID = createCustomPrj(cpName, sid, courseID, -1);
		// 新建源文件文件夹
		int sourceID = createCustomPrj("源文件", sid, courseID, cpID);
		// 新建头文件文件夹
		int headID = createCustomPrj("头文件", sid, courseID, cpID);
		idMap.put("cpID", cpID);
		idMap.put("sourceID", sourceID);
		idMap.put("headID", headID);
		return idMap;

	}

	/**
	 * 插入项目
	 * 
	 * @param cpName
	 * @param sid
	 * @param courseID
	 * @param parentID
	 * @return
	 */
	private int createCustomPrj(String cpName, int sid, int courseID, int parentID) {
		CustomPrjTable prjTable = new CustomPrjTable();
		prjTable.setCpName(cpName);
		prjTable.setParentID(parentID);
		prjTable.setUpdateTime(new Timestamp(System.currentTimeMillis()));
		prjTable.setStudent((StudentTable) getSession().get(StudentTable.class, sid));
		prjTable.setCourse((CourseTable) getSession().get(CourseTable.class, courseID));
		getSession().save(prjTable);
		// 返回cpID
		return prjTable.getCpID();
	}
}
