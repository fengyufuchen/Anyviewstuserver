package com.anyview.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.anyview.codec.pojo.response.CustomFile;
import com.anyview.codec.pojo.response.CustomProject;
import com.anyview.dao.PkCustomPrjDao;
import com.anyview.entities.SchemeTable;

/**
 * 
 * @author 杨坚新
 *
 */
@Repository
public class PkCustomPrjDaoImpl extends BaseDaoImpl implements PkCustomPrjDao {

	@Override
	public List<CustomProject> getCustomPrj(int sid) {
		List<CustomProject> result = new ArrayList<>();
		// 获取项目的主键id，项目名称，更新时间
		String query1 = "select new map(cpID as cpID,cpName as cpName,updateTime as updateTime) from CustomPrjTable where student.sid=? and parentID=-1";
		// 获得对应项目中的文件夹中的文件
		String query2 = "select new com.anyview.codec.pojo.response.CustomFile(t.cfID,t.cfName,t.eContent,t.eComment,t.kind,t.cmpStatus,t.memo,t.score,t.updateTime,t.createTime) from CustomFileTable as t where t.directory=(select prjTable.cpID from CustomPrjTable as prjTable where prjTable.parentID=? and prjTable.cpName=?)";
		// 所有项目的集合
		List<Map> list = getSession().createQuery(query1).setInteger(0, sid).list();
		for (Map map : list) {
			int cpID = (int) map.get("cpID");
			String cpName = (String) map.get("cpName");
			Date updateTime = (Date) map.get("updateTime");
			// 一个项目的源文件集合
			List<CustomFile> sourceFiles = getSession().createQuery(query2).setInteger(0, cpID).setString(1, "源文件")
					.list();
			// 一个项目的头文件的集合
			List<CustomFile> headFiles = getSession().createQuery(query2).setInteger(0, cpID).setString(1, "头文件")
					.list();
			// 创建一个项目实例
			CustomProject customProject = new CustomProject(cpID,cpName, sourceFiles, headFiles, updateTime);
			result.add(customProject);
		}
		return result;
	}

}
