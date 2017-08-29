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
@Table(name = "CustomPrjTable", catalog = "anyviewdb")
public class CustomPrjTable implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer cpID;// 主键
	private String cpName;// 项目名称
	private StudentTable student;// 学生
	private CourseTable course;// 课程
	private Integer parentID;// 父项目目录
	private Timestamp updateTime;// 更新时间

	@Id
	@Column(name = "CPID", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getCpID() {
		return cpID;
	}

	public void setCpID(Integer cpID) {
		this.cpID = cpID;
	}

	@Column(name = "CPName", length = 255)
	public String getCpName() {
		return cpName;
	}

	public void setCpName(String cpName) {
		this.cpName = cpName;
	}

	@ManyToOne(targetEntity = StudentTable.class)
	@JoinColumn(name = "SID", nullable = true)
	public StudentTable getStudent() {
		return student;
	}

	public void setStudent(StudentTable student) {
		this.student = student;
	}

	@ManyToOne(targetEntity = CourseTable.class)
	@JoinColumn(name = "CourseID", nullable = true)
	public CourseTable getCourse() {
		return course;
	}

	public void setCourse(CourseTable course) {
		this.course = course;
	}

	@Column(name = "ParentID")
	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}

	@Column(name = "UpdateTime")
	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}
