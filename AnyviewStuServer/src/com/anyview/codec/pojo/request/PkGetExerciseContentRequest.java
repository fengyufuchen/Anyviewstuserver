package com.anyview.codec.pojo.request;

import java.io.Serializable;

public class PkGetExerciseContentRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contexID;
	private Integer eid;

	public String getContexID() {
		return contexID;
	}

	public void setContexID(String contexID) {
		this.contexID = contexID;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public Integer getEid() {
		return eid;
	}

	@Override
	public String toString() {
		return "PkGetExerciseContentRequest [contexID=" + contexID + ", eid=" + eid + "]";
	}

}
