package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkUpdateCustomFileNameRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private String contextID;
	private int cfID;
	private String cfName;

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

	public String getCfName() {
		return cfName;
	}

	public void setCfName(String cfName) {
		this.cfName = cfName;
	}

	@Override
	public String toString() {
		return "PkUpdateCustomFileNameRequest [contextID=" + contextID + ", cfID=" + cfID + ", cfName=" + cfName + "]";
	}

}
