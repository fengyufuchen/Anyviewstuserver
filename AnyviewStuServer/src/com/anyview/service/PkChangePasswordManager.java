package com.anyview.service;

import java.util.List;

import com.anyview.entities.StudentTable;

public interface PkChangePasswordManager {
	/**
	 * 根据 学生ID 查询学生的信息
	 * 读取表StudentTable中相应的数据
	 * @param 学生ID
	 * @return 查询StudentTable结果列表
	 * 返回值类型：List，泛型：StudentTable
	 */
	public List<StudentTable> getStudentInfo(int sid);
	/**
	 * 修改数据库StudentTable对应学生的密码
	 * @param 新密码
	 * @param 学生ID
	 */
	public void setnewPassword(int Sid,String NewSPsw );
	
	
	
}
