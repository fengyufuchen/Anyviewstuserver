package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * 
 * @author 杨坚新
 *
 */
public class PkAddCustomFileRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	private String contextID;
	private String cfName;
	private String content;
	private int cpID;

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public String getCfName() {
		return cfName;
	}

	public void setCfName(String cfName) {
		this.cfName = cfName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCpID() {
		return cpID;
	}

	public void setCpID(int cpID) {
		this.cpID = cpID;
	}

	@Override
	public String toString() {
		return "PkAddCustomFileRequest [contextID=" + contextID + ", cfName=" + cfName + ", content=" + content
				+ ", cpID=" + cpID + "]";
	}

}
