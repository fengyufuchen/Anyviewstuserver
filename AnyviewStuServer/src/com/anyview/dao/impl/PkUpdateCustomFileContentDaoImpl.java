package com.anyview.dao.impl;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

import com.anyview.dao.PkUpdateCustomFileContentDao;
import com.anyview.entities.CustomFileTable;
import com.anyview.entities.CustomPrjTable;

/**
 * 
 * @author 杨坚新
 *
 */
@Repository
public class PkUpdateCustomFileContentDaoImpl extends BaseDaoImpl implements PkUpdateCustomFileContentDao {

	@Override
	public boolean updateCustomFileResult(int cfID, String content) {
		try {
			Timestamp now = new Timestamp(System.currentTimeMillis());
			CustomFileTable customFile = (CustomFileTable) getSession().get(CustomFileTable.class, cfID);
			// 设置文件内容
			customFile.seteContent(content);
			// 设置文件更新时间
			customFile.setUpdateTime(now);

			// 文件所在的文件夹
			CustomPrjTable directory = (CustomPrjTable) getSession().get(CustomPrjTable.class,
					customFile.getDirectory().getCpID());
			// 设置文件夹的更新时间
			directory.setUpdateTime(now);

			// 文件所在项目
			CustomPrjTable customPrj = (CustomPrjTable) getSession().get(CustomPrjTable.class, directory.getParentID());
			// 设置项目的更新时间
			customPrj.setUpdateTime(now);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
