package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkUpdateCustomFileContentRequest implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cotextID;
	private int cfID;
	// 更新内容
	private String content;

	public String getCotextID() {
		return cotextID;
	}

	public void setCotextID(String cotextID) {
		this.cotextID = cotextID;
	}

	public int getCfID() {
		return cfID;
	}

	public void setCfID(int cfID) {
		this.cfID = cfID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "PkUpdateCustomFileRequest [cotextID=" + cotextID + ", cfID=" + cfID + ", content=" + content + "]";
	}

}
