package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkCustomPrjRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cotextID;
	private int sid;

	public String getCotextID() {
		return cotextID;
	}

	public void setCotextID(String cotextID) {
		this.cotextID = cotextID;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "PkCustomPrjRequest [cotextID=" + cotextID + ", sid=" + sid + "]";
	}

}
