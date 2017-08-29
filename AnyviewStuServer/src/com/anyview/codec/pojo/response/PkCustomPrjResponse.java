package com.anyview.codec.pojo.response;

import java.io.Serializable;
import java.util.List;

public class PkCustomPrjResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private String contextID;
	private CustomPrjState customPrjState;
	//所有项目的集合
	private List<CustomProject> customProjects;

	public static enum CustomPrjState {
		getCustomPrjState, prjNotExist
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public CustomPrjState getCustomPrjState() {
		return customPrjState;
	}

	public void setCustomPrjState(CustomPrjState customPrjState) {
		this.customPrjState = customPrjState;
	}

	public List<CustomProject> getCustomProjects() {
		return customProjects;
	}

	public void setCustomProjects(List<CustomProject> customProjects) {
		this.customProjects = customProjects;
	}

}
