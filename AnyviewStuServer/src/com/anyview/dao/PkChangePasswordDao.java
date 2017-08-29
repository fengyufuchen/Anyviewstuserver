package com.anyview.dao;

import java.util.List;

import com.anyview.entities.StudentTable;

public interface PkChangePasswordDao {
	public List<StudentTable> getStudentInfo(int Sid);
	public void setnewPassword(int Sid, String NewSPsw);
}
