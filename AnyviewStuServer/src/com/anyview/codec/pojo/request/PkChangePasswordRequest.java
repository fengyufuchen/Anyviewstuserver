package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * @author 李海峰
 *
 */
public class PkChangePasswordRequest implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//学生ID
	private int sid;
	
	//旧密码
	private String oldSPsw;
	
	//新密码
	private String newSPsw;
	
	//上下文ID
	private String contextID;
	


	public String getOldSPsw() {
		return oldSPsw;
	}
	public void setOldSPsw(String oldSPsw) {
		this.oldSPsw = oldSPsw;
	}
	public String getNewSPsw() {
		return newSPsw;
	}
	public void setNewSPsw(String newSPsw) {
		this.newSPsw = newSPsw;
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
}