package com.anyview.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author 杨坚新
 *
 */
@Entity
@Table(name = "CustomFileTable", catalog = "anyviewdb")
public class CustomFileTable implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer cfID;// 项目文件ID
	private String cfName;// 文件名称
	private CustomPrjTable directory;// 所在项目目录
	private String eContent;// 文件内容
	private String eComment;// 教师评语
	private Integer kind;// 文件类型
	private Integer cmpStatus;// 编译状态
	private String memo;// 文件说明
	private Float score;// 得分
	private Timestamp updateTime;// 修改时间
	private Timestamp createTime;// 创建时间

	@Id
	@Column(name = "CFID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCfID() {
		return cfID;
	}

	public void setCfID(Integer cfID) {
		this.cfID = cfID;
	}

	@Column(name = "CFName", length = 255)
	public String getCfName() {
		return cfName;
	}

	public void setCfName(String cfName) {
		this.cfName = cfName;
	}

	@ManyToOne(targetEntity = CustomPrjTable.class)
	@JoinColumn(name = "CPID", nullable = true)
	public CustomPrjTable getDirectory() {
		return directory;
	}

	public void setDirectory(CustomPrjTable directory) {
		this.directory = directory;
	}

	@Column(name = "EContent")
	public String geteContent() {
		return eContent;
	}

	public void seteContent(String eContent) {
		this.eContent = eContent;
	}

	@Column(name = "EComment")
	public String geteComment() {
		return eComment;
	}

	public void seteComment(String eComment) {
		this.eComment = eComment;
	}

	@Column(name = "Kind")
	public Integer getKind() {
		return kind;
	}

	public void setKind(Integer kind) {
		this.kind = kind;
	}

	@Column(name = "CmpStatus")
	public Integer getCmpStatus() {
		return cmpStatus;
	}

	public void setCmpStatus(Integer cmpStatus) {
		this.cmpStatus = cmpStatus;
	}

	@Column(name = "Memo", length = 4000)
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Column(name = "Score")
	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	@Column(name = "UpdateTime")
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

	@Column(name = "CreateTime")
	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

}
