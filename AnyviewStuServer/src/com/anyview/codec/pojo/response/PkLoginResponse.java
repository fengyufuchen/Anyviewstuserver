package com.anyview.codec.pojo.response;

import java.io.Serializable;

public class PkLoginResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LoginState loginState; // 登录状态
	private String ipAddress; // 远程IP地址
	private int port; // 远程端口
	private int sid;// 学生id
	private String sname;// 学生名字
	private int unid;// 学校id
	private String unName;// 学校名称
	private int cid;// 班级id
	private String cname;// 班级名称
	private String sex; // 性别
	private String contextID; // 上下文ID

	// private String subscriberName; // 姓名
	// private String universityName; // 学校名
	// private String className; // 班级名
	// private String courseName; // 课程名

	public static enum LoginState {
		LoginSuccess, AccountNotExist, PasswordError, DupeLogin, AccountDisabled;
	}

	public LoginState getLoginState() {
		return loginState;
	}

	public void setLoginState(LoginState loginState) {
		this.loginState = loginState;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getUnid() {
		return unid;
	}

	public void setUnid(int unid) {
		this.unid = unid;
	}

	public String getUnName() {
		return unName;
	}

	public void setUnName(String unName) {
		this.unName = unName;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

}