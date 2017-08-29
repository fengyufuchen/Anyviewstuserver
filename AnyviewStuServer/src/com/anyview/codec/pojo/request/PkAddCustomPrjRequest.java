package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * 
 * @author 杨坚新
 *
 */
public class PkAddCustomPrjRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String contextID;
	private String cpName;
	private int sid;
	private int courseID;

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	@Override
	public String toString() {
		return "PkAddCustomPrjRequest [contextID=" + contextID + ", cpName=" + cpName + ", sid=" + sid + ", courseID="
				+ courseID + "]";
	}

}
