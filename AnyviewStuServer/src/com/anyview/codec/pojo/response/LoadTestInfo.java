package com.anyview.codec.pojo.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author 杨坚新
 *
 */
public class LoadTestInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	// 考试名称
	private String epName;
	// 考试持续时间
	private Integer duration;
	// 考试开始时间
	private Date testStartTime;
	// 考试题目
	private List<CatalogInfo> catalogInfo = new ArrayList<>();

	public String getEpName() {
		return epName;
	}

	public void setEpName(String epName) {
		this.epName = epName;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Date getTestStartTime() {
		return testStartTime;
	}

	public void setTestStartTime(Date testStartTime) {
		this.testStartTime = testStartTime;
	}

	public List<CatalogInfo> getCatalogInfo() {
		return catalogInfo;
	}

	public void setCatalogInfo(List<CatalogInfo> catalogInfo) {
		this.catalogInfo = catalogInfo;
	}

	public LoadTestInfo(String epName, Integer duration, Date testStartTime, List<CatalogInfo> catalogInfo) {
		this.epName = epName;
		this.duration = duration;
		this.testStartTime = testStartTime;
		this.catalogInfo = catalogInfo;
	}
}
