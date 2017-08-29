package com.anyview.dao;

import java.util.List;

import com.anyview.entities.StudentTable;

public interface PkLoginDao {

	public List<StudentTable> getStudentInfo(String userAccount, int universityID);

	public String getUnNameByUnid(int unid);

	public String getCNameByCid(int cid);

	public void setLoginSuccessStatus(String subscriberAccount, int universityID, String ip, int port);
}
