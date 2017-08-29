package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkUpdateCustomPrjNameRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private String contextID;
	private int cpID;
	private String cpName;

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

	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	@Override
	public String toString() {
		return "PkUpdateCustomPrjNameRequest [contextID=" + contextID + ", cpID=" + cpID + ", cpName=" + cpName + "]";
	}

}
