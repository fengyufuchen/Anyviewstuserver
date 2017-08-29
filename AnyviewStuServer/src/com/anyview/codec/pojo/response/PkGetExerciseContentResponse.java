package com.anyview.codec.pojo.response;

import java.io.Serializable;

public class PkGetExerciseContentResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String contextID;
	private String content;
	private GetExerciseContentState state;
	private String pName;
	private Integer pid;

	public enum GetExerciseContentState {
		getExerciseContentSuccess, exerciseContentIsNull
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public GetExerciseContentState getState() {
		return state;
	}

	public void setState(GetExerciseContentState state) {
		this.state = state;
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
		return "PkGetExerciseContentResponse [contextID=" + contextID + ", content=" + content + ", state=" + state
				+ ", pName=" + pName + ", pid=" + pid + "]";
	}

}
