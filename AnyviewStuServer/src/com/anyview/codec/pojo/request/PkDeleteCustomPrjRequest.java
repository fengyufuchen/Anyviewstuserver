package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkDeleteCustomPrjRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private String contextID;
	private int cpID;

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public int getCpID() {
		return cpID;
	}

	public void setCpID(int cpID) {
		this.cpID = cpID;
	}

	@Override
	public String toString() {
		return "deleteCustomPrjRequest [contextID=" + contextID + ", cpID=" + cpID + "]";
	}

}
