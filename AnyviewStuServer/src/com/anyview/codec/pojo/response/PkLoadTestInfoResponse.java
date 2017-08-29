package com.anyview.codec.pojo.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author 杨坚新
 *
 */
public class PkLoadTestInfoResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<LoadTestInfo> testInfo;
	private String contextID;
	private LoadTestInfoState loadTestInfoState;

	public static enum LoadTestInfoState {
		// 考试编排表停用
		// ExamPlanTableStop,
		// 考试计划表停用
		// SchemeTableStop,
		// 获取考试信息成功
		LoadTestInfoSuccss,
		// 获取考试信息失败
		LoadTestInfoFailure
	}

	public List<LoadTestInfo> getTestInfo() {
		return testInfo;
	}

	public void setTestInfo(List<LoadTestInfo> testInfo) {
		this.testInfo = testInfo;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	public LoadTestInfoState getLoadTestInfoState() {
		return loadTestInfoState;
	}

	public void setLoadTestInfoState(LoadTestInfoState loadTestInfoState) {
		this.loadTestInfoState = loadTestInfoState;
	}

}
