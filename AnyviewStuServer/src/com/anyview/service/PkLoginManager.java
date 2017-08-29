package com.anyview.service;

import java.util.List;

import com.anyview.entities.StudentTable;

/**
 * 
 * @author 吴汪洋
 * @Date 2016.03.30
 *
 */
public interface PkLoginManager {

	/**
	 * 根据 学号和学校ID 查询学生的信息 读取表StudentTable中相应的数据
	 * 
	 * @param 学号
	 * @param 学校ID
	 * @return 查询StudentTable结果列表 返回值类型：List，泛型：StudentTable
	 */
	public List<StudentTable> getStudentInfo(String userAccount, int universityID);

	/**
	 * 设置成功登录的状态，更新数据库StudentTable
	 * 
	 * @param subscriberAccount
	 *            学号
	 * @param universityID
	 *            学校ID
	 * @param ip
	 *            远程登录ip地址
	 * @param port
	 *            远程登录端口
	 */
	public void setLoginSuccessStatus(String subscriberAccount, int universityID, String ip, int port);

	public String getUnNameByUnid(int unid);

	public String getCNameByCid(int cid);
}
