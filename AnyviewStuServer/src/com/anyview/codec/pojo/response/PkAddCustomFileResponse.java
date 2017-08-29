package com.anyview.codec.pojo.response;

import java.io.Serializable;

/**
 * 
 * 
 * @author 杨坚新
 *
 */
public class PkAddCustomFileResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private String contextID;
	private int cfID;
	private PkAddCustomFileState pkAddCustomFileState;

	public enum PkAddCustomFileState {
		// 新建文件成功
		addFileSuccess,
		// 新建文件失败
		addFileFailure
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public int getCfID() {
		return cfID;
	}

	public void setCfID(int cfID) {
		this.cfID = cfID;
	}

	public PkAddCustomFileState getPkAddCustomFileState() {
		return pkAddCustomFileState;
	}

	public void setPkAddCustomFileState(PkAddCustomFileState pkAddCustomFileState) {
		this.pkAddCustomFileState = pkAddCustomFileState;
	}

	@Override
	public String toString() {
		return "PkAddCustomFileResponse [contextID=" + contextID + ", cfID=" + cfID + ", pkAddCustomFileState="
				+ pkAddCustomFileState + "]";
	}

}
