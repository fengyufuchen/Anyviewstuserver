package com.anyview.codec.pojo.response;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkDeleteCustomPrjResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String contextID;
	private DeleteCustomPrjState deleteCustomPrjState;

	public static enum DeleteCustomPrjState {
		// 删除项目成功
		deletePrjSuccess,
		// 删除项目失败
		deletePrjFailure
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public DeleteCustomPrjState getDeleteCustomPrjState() {
		return deleteCustomPrjState;
	}

	public void setDeleteCustomPrjState(DeleteCustomPrjState deleteCustomPrjState) {
		this.deleteCustomPrjState = deleteCustomPrjState;
	}

	@Override
	public String toString() {
		return "PkDeleteCustomPrjResponse [contextID=" + contextID + ", deleteCustomPrjState=" + deleteCustomPrjState
				+ "]";
	}

}
