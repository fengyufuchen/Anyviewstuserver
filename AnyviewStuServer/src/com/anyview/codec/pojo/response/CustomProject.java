package com.anyview.codec.pojo.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author 杨坚新
 *
 */
public class CustomProject implements Serializable {

	private static final long serialVersionUID = 1L;
	// 项目ID
	private int cpID;
	// 项目名称
	private String cpName;
	// 源文件
	private List<CustomFile> sourceFiles;
	// 源文件
	private List<CustomFile> headFiles;
	// 项目更新时间
	private Date updateTime;

	public CustomProject(int cpID, String cpName, List<CustomFile> sourceFiles, List<CustomFile> headFiles,
			Date updateTime) {
		this.cpID = cpID;
		this.cpName = cpName;
		this.sourceFiles = sourceFiles;
		this.headFiles = headFiles;
		this.updateTime = updateTime;
	}

	public List<CustomFile> getSourceFiles() {
		return sourceFiles;
	}

	public void setSourceFiles(List<CustomFile> sourceFiles) {
		this.sourceFiles = sourceFiles;
	}

	public List<CustomFile> getHeadFiles() {
		return headFiles;
	}

	public void setHeadFiles(List<CustomFile> headFiles) {
		this.headFiles = headFiles;
	}

	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public int getCpID() {
		return cpID;
	}

	public void setCpID(int cpID) {
		this.cpID = cpID;
	}

	@Override
	public String toString() {
		return "CustomProject [cpID=" + cpID + ", cpName=" + cpName + ", sourceFiles=" + sourceFiles + ", headFiles="
				+ headFiles + ", updateTime=" + updateTime + "]";
	}

}
