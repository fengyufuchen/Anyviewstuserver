package com.anyview.codec.pojo.response;

import java.io.Serializable;

public final class PkChangePasswordResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ChangePswEnum changePswEnumState;
	private String contextID;
	
	public static enum ChangePswEnum {
		PwdChangeSuccess,
		OldPwdError;
	}

	public ChangePswEnum getChangePswEnumState() {
		return changePswEnumState;
	}

	public void setChangePswEnumState(ChangePswEnum changePswEnumState) {
		this.changePswEnumState = changePswEnumState;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}
	
}