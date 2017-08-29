package com.anyview.codec.pojo.request;

import java.io.Serializable;

public class PkGetClassRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private String sno;
	private int unid;
	private String contextID;

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public int getUnid() {
		return unid;
	}

	public void setUnid(int unid) {
		this.unid = unid;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

}
