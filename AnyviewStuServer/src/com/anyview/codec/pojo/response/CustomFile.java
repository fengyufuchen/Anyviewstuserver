package com.anyview.codec.pojo.response;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author 杨坚新
 *
 */
public class CustomFile implements Serializable {
	private static final long serialVersionUID = 1L;
	// 文件ID
	private int cfID;
	// 文件名
	private String cfName;
	// 文件内容
	private String eContent;
	// 教师评语
	private String eComment;
	// 文件类型
	private Integer kind;
	// 编译状态
	private Integer cmpStatus;
	// 文件说明
	private String memo;
	// 得分
	private Float score;
	// 修改时间
	private Date updateTime;
	// 创建时间
	private Date createTime;

	public int getCfID() {
		return cfID;
	}

	public void setCfID(int cfID) {
		this.cfID = cfID;
	}

	public String getCfName() {
		return cfName;
	}

	public void setCfName(String cfName) {
		this.cfName = cfName;
	}

	public String geteContent() {
		return eContent;
	}

	public void seteContent(String eContent) {
		this.eContent = eContent;
	}

	public String geteComment() {
		return eComment;
	}

	public void seteComment(String eComment) {
		this.eComment = eComment;
	}

	public Integer getKind() {
		return kind;
	}

	public void setKind(Integer kind) {
		this.kind = kind;
	}

	public Integer getCmpStatus() {
		return cmpStatus;
	}

	public void setCmpStatus(Integer cmpStatus) {
		this.cmpStatus = cmpStatus;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public CustomFile(int cfID, String cfName, String eContent, String eComment, Integer kind, Integer cmpStatus,
			String memo, Float score, Date updateTime, Date createTime) {
		this.cfID = cfID;
		this.cfName = cfName;
		this.eContent = eContent;
		this.eComment = eComment;
		this.kind = kind;
		this.cmpStatus = cmpStatus;
		this.memo = memo;
		this.score = score;
		this.updateTime = updateTime;
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "CustomFile [cfID=" + cfID + ", cfName=" + cfName + ", eContent=" + eContent + ", eComment=" + eComment
				+ ", kind=" + kind + ", cmpStatus=" + cmpStatus + ", memo=" + memo + ", score=" + score
				+ ", updateTime=" + updateTime + ", createTime=" + createTime + "]";
	}

}
