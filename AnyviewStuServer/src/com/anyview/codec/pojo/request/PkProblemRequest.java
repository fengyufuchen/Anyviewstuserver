package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkProblemRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	private String pid;
	private String contextID;

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	@Override
	public String toString() {
		return "PkProblemRequest [pid=" + pid + ", contextID=" + contextID + "]";
	}

}
