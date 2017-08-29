package com.anyview.dao.impl;

import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

import com.anyview.dao.PkAddCustomFileDao;
import com.anyview.entities.CustomFileTable;
import com.anyview.entities.CustomPrjTable;

/**
 * 
 * 
 * @author 杨坚新
 *
 */
@Repository
public class PkAddCustomFileDaoImpl extends BaseDaoImpl implements PkAddCustomFileDao {

	@Override
	public int addCustomFile(int cpID, String cfName, String content) {
		try {
			CustomFileTable customFile = new CustomFileTable();
			customFile.setCfName(cfName);
			CustomPrjTable custommPrj = (CustomPrjTable) getSession().get(CustomPrjTable.class, cpID);
			customFile.setDirectory(custommPrj);
			customFile.seteContent(content);
			customFile.setCmpStatus(0);
			Timestamp time = new Timestamp(System.currentTimeMillis());
			customFile.setUpdateTime(time);
			customFile.setCreateTime(time);
			getSession().save(customFile);
			return customFile.getCfID();
		} catch (Exception e) {
			return -1;
		}
	}

}
