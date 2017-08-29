package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkDeleteCustomFileRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String contextID;
	private int cfID;

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public int getCfID() {
		return cfID;
	}

	public void setCfID(int cfID) {
		this.cfID = cfID;
	}

	@Override
	public String toString() {
		return "PkDeleteCustomFileRequest [contextID=" + contextID + ", cfID=" + cfID + "]";
	}

}
