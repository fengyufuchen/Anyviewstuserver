package com.anyview.dao.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.stereotype.Repository;

import com.anyview.dao.PkLogoutDao;
import com.anyview.entities.StudentTable;

/**
 * 
 * @author 杨坚新
 *
 */
@Repository
public class PkLogoutDaoImpl extends BaseDaoImpl implements PkLogoutDao {

	public boolean updateStudentLoginState(String sid) {
		StudentTable student = (StudentTable) getSession().get(StudentTable.class, Integer.parseInt(sid));
		// 登录状态
		int loginStatus = student.getLoginStatus();
		// 用户处于登录状态，退出登录，修改登录状态
		if (loginStatus == 1) {
			System.out.println("loginStatus=1");
			student.setLoginStatus(0);
			return true;
		}
		// 用户尚未登录
		return false;
	}

}
