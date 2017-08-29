package com.anyview.codec.pojo.response;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkProblemResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String pContent;
	private String contextID;
	private ProblemState problemState;
	private String pName;
	private Integer pid;

	public static enum ProblemState {
		getproblemSuccess, problemCotentIsNull
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public ProblemState getProblemState() {
		return problemState;
	}

	public void setProblemState(ProblemState problemState) {
		this.problemState = problemState;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "PkProblemResponse [pContent=" + pContent + ", contextID=" + contextID + ", problemState=" + problemState
				+ ", pName=" + pName + ", pid=" + pid + "]";
	}

}
