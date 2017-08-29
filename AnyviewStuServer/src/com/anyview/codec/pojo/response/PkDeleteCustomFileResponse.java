package com.anyview.codec.pojo.response;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkDeleteCustomFileResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String contextID;
	private DeleteCustomFileState deleteCustomFileState;

	public static enum DeleteCustomFileState {
		// 删除项目成功
		deleteFileSuccess,
		// 删除项目失败
		deleteFileFailure
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public DeleteCustomFileState getDeleteCustomFileState() {
		return deleteCustomFileState;
	}

	public void setDeleteCustomFileState(DeleteCustomFileState deleteCustomFileState) {
		this.deleteCustomFileState = deleteCustomFileState;
	}

	@Override
	public String toString() {
		return "PkDeleteCustomFileResponse [contextID=" + contextID + ", deleteCustomFileState=" + deleteCustomFileState
				+ "]";
	}
}
