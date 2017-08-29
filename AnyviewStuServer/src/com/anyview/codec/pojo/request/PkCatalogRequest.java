package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 * 
 */
public class PkCatalogRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private String sid;
	private String cid;
	private String contextID;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	@Override
	public String toString() {
		return "PkCatalogRequest [sid=" + sid + ", cid=" + cid + ", contextID=" + contextID + "]";
	}

}
