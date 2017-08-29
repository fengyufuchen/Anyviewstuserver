package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * @author 杨坚新
 */
public class PkLogoutRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String contextID;
	private String sid;

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

}