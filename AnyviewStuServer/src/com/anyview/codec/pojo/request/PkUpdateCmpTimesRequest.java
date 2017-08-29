package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * @author 李海峰
 *
 */

public class PkUpdateCmpTimesRequest implements Serializable{
private static final long serialVersionUID = 1L;
	
	private String eid;
	private int cmpcount;
	private int cmprightcount;
	private int cmperrorcount;
	
	private String contextID;
	

	public String getContextID() {
		return contextID;
	}
	public void setContextID(String contextID) {
		this.contextID = contextID;
	}
	public int getCmpcount() {
		return cmpcount;
	}
	public void setCmpcount(int cmpcount) {
		this.cmpcount = cmpcount;
	}
	public int getCmprightcount() {
		return cmprightcount;
	}
	public void setCmprightcount(int cmprightcount) {
		this.cmprightcount = cmprightcount;
	}
	public int getCmperrorcount() {
		return cmperrorcount;
	}
	public void setCmperrorcount(int cmperrorcount) {
		this.cmperrorcount = cmperrorcount;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	
	
}
