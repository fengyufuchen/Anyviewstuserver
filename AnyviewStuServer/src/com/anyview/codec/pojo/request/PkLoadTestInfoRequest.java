package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * @author 杨坚新
 */
public class PkLoadTestInfoRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contextID;
	private String cid;
	private String courceID;

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCourceID() {
		return courceID;
	}

	public void setCourceID(String courceID) {
		this.courceID = courceID;
	}

	@Override
	public String toString() {
		return "PkLoadTestInfoRequest [contextID=" + contextID + ", cid=" + cid + ", courceID=" + courceID + "]";
	}

}
