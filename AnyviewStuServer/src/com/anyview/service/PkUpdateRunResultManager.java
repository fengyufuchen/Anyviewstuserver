package com.anyview.service;

/**
 * 
 * @author 李海峰
 */

public interface PkUpdateRunResultManager {
	
	
	/**
	 * 修改数据库esercisetable对应学生的运行次数
	 * @param 作业答案ID
	 * @param 运行错误次数
	 * @param 运行次数
	 */
	public void updateRunResult(String eid, int runresult,int runerrcount);

}
