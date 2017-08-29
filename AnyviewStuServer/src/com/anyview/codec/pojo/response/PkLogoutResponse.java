package com.anyview.codec.pojo.response;

import java.io.Serializable;
/**
 * @author jianxin
 */
public class PkLogoutResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private LogoutState logoutState;
	private String contextID;
	
	public static enum LogoutState {
		LogoutSuccess,
		NotLogin;
	}

	public LogoutState getLogoutState() {
		return logoutState;
	}

	public void setLogoutState(LogoutState logoutState) {
		this.logoutState = logoutState;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	@Override
	public String toString() {
		return "SubscriberLogoutResponse [logoutState=" + logoutState + ", contextID=" + contextID + "]";
	}
	
}