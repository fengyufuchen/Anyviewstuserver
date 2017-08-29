package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * @author 吴汪洋
 *
 */
public class PkLoginRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String sno;
	private String password;
	private int unid;
	private String contextID;
	private int cid;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUnid() {
		return unid;
	}

	public void setUnid(int unid) {
		this.unid = unid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

}