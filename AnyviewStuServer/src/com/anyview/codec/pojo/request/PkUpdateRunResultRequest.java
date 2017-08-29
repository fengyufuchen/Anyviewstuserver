package com.anyview.codec.pojo.request;

import java.io.Serializable;

/**
 * 
 * @author 李海峰
 *
 */

public class PkUpdateRunResultRequest implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String eid;
	private int runresult;
	private int runerrcount;
	private String contextID;
	
	public int getRunresult() {
		return runresult;
	}
	public void setRunresult(int runresult) {
		this.runresult = runresult;
	}
	public int getRunerrcount() {
		return runerrcount;
	}
	public void setRunerrcount(int runerrcount) {
		this.runerrcount = runerrcount;
	}
	public String getContextID() {
		return contextID;
	}
	public void setContextID(String contextID) {
		this.contextID = contextID;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	
	
}
