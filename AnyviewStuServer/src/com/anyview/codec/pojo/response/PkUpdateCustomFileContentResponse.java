package com.anyview.codec.pojo.response;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkUpdateCustomFileContentResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private UpdateCustomFileState updateCustomFileState;
	private String contextID;

	// 更新文件是否成功
	public static enum UpdateCustomFileState {
		updateSuccess, // 修改成功
		updateFailure// 修改失败
	}

	public UpdateCustomFileState getUpdateCustomFileState() {
		return updateCustomFileState;
	}

	public void setUpdateCustomFileState(UpdateCustomFileState updateCustomFileState) {
		this.updateCustomFileState = updateCustomFileState;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	@Override
	public String toString() {
		return "PkUpdateCustomFileResponse [updateCustomFileState=" + updateCustomFileState + ", contextID=" + contextID
				+ "]";
	}

}
