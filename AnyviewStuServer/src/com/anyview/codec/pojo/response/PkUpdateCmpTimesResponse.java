package com.anyview.codec.pojo.response;

import java.io.Serializable;

/**
 * 
 * @author 李海峰
 */
public class PkUpdateCmpTimesResponse implements Serializable{
    private static final long serialVersionUID = 1L;
	
	private UpdateCmpTimesEnum UpdateCmpTimesEnumState;
	private String contextID;
	
	public static enum UpdateCmpTimesEnum {
		UpdateSuccess,
		SystemError;
	}

	
	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public UpdateCmpTimesEnum getUpdateCmpTimesEnumState() {
		return UpdateCmpTimesEnumState;
	}

	public void setUpdateCmpTimesEnumState(UpdateCmpTimesEnum updateCmpTimesEnumState) {
		UpdateCmpTimesEnumState = updateCmpTimesEnumState;
	}
}
