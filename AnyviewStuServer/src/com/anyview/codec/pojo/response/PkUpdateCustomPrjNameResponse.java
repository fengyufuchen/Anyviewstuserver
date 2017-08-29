package com.anyview.codec.pojo.response;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkUpdateCustomPrjNameResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String contextID;
	private PkUpdateCustomPrjNameState pkUpdateCustomPrjNameState;

	public enum PkUpdateCustomPrjNameState {
		// 修改文件名称成功
		updatePrjNameSuccess,
		// 修改文件名称失败
		updatePrjNameFailure
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public PkUpdateCustomPrjNameState getPkUpdateCustomPrjNameState() {
		return pkUpdateCustomPrjNameState;
	}

	public void setPkUpdateCustomPrjNameState(PkUpdateCustomPrjNameState pkUpdateCustomPrjNameState) {
		this.pkUpdateCustomPrjNameState = pkUpdateCustomPrjNameState;
	}

	@Override
	public String toString() {
		return "PkUpdateCustomPrjNameResponse [contextID=" + contextID + ", pkUpdateCustomPrjNameState="
				+ pkUpdateCustomPrjNameState + "]";
	}

}
