package com.anyview.codec.pojo.response;

import java.io.Serializable;

/**
 * 
 * @author 李海峰
 */
public class PkUpdateRunResultResponse implements Serializable{
       private static final long serialVersionUID = 1L;
	
	private UpdateRunResultEnum UpdateRunResultEnumState;
	private String contextID;
	
	public static enum UpdateRunResultEnum {
		UpdateSuccess,
		SystemError;
	}

	public UpdateRunResultEnum getUpdateRunResultEnumState() {
		return UpdateRunResultEnumState;
	}

	public void setUpdateRunResultEnumState(UpdateRunResultEnum updateRunResultEnumState) {
		UpdateRunResultEnumState = updateRunResultEnumState;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}
}
