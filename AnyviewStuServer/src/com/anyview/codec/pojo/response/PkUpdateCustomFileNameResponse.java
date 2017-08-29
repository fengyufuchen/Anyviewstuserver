package com.anyview.codec.pojo.response;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkUpdateCustomFileNameResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String contextID;
	private PkUpdateCustomFileNameState pkUpdateCustomFileNameState;

	public enum PkUpdateCustomFileNameState {
		// 修改文件名称成功
		updateFileNameSuccess,
		// 修改文件名称失败
		updateFileNameFailure
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public PkUpdateCustomFileNameState getPkUpdateCustomFileNameState() {
		return pkUpdateCustomFileNameState;
	}

	public void setPkUpdateCustomFileNameState(PkUpdateCustomFileNameState pkUpdateCustomFileNameState) {
		this.pkUpdateCustomFileNameState = pkUpdateCustomFileNameState;
	}

	@Override
	public String toString() {
		return "PkUpdateCustomFileNameResponse [contextID=" + contextID + ", pkUpdateCustomFileNameState="
				+ pkUpdateCustomFileNameState + "]";
	}

}
