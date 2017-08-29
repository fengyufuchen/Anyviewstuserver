package com.anyview.codec.pojo.response;

import java.io.Serializable;

/**
 * 
 * 
 * @author 杨坚新
 *
 */
public class PkAddCustomPrjResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String contextID;
	private PkAddCustomPrjState pkAddCustomPrjState;
	// 项目ID
	private int cpID;
	// 源文件ID
	private int sourceCfID;
	// 头文件ID
	private int headCfID;

	public static enum PkAddCustomPrjState {
		// 添加成功
		addPrjSuccess,
		// 删除失败
		addPrjFailure
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public PkAddCustomPrjState getPkAddCustomPrjState() {
		return pkAddCustomPrjState;
	}

	public void setPkAddCustomPrjState(PkAddCustomPrjState pkAddCustomPrjState) {
		this.pkAddCustomPrjState = pkAddCustomPrjState;
	}

	public int getCpID() {
		return cpID;
	}

	public void setCpID(int cpID) {
		this.cpID = cpID;
	}

	public int getSourceCfID() {
		return sourceCfID;
	}

	public void setSourceCfID(int sourceCfID) {
		this.sourceCfID = sourceCfID;
	}

	public int getHeadCfID() {
		return headCfID;
	}

	public void setHeadCfID(int headCfID) {
		this.headCfID = headCfID;
	}

	@Override
	public String toString() {
		return "PkAddCustomPrjResponse [contextID=" + contextID + ", pkAddCustomPrjState=" + pkAddCustomPrjState
				+ ", cpID=" + cpID + ", sourceCfID=" + sourceCfID + ", headCfID=" + headCfID + "]";
	}

}
