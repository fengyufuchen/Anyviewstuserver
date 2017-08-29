package com.anyview.service;



/**
 * 
 * @author 李海峰
 */

public interface PkUpdateCmpTimesManager {
	
	/**
	 * 修改数据库esercisetable对应题目的信息
	 * @param 作业答案ID
	 * @param 编译次数
	 * @param 正确次数
	 * @param 错误次数
	 */
	public void updateCmpTimesDao(String eid, int cmpcount, int cmprightcount,
			int cmperrorcount);
}
