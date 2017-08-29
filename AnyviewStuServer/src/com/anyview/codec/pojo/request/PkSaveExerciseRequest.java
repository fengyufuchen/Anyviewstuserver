package com.anyview.codec.pojo.request;

import java.io.Serializable;
/**
 * 
 * @author 李海峰
 *
 */
public class PkSaveExerciseRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private AnyProtocolKind subscriberOrder;
	private String eid;
	private String econtent;
	
	private String contextID;
	public AnyProtocolKind getSubscriberOrder() {
		return subscriberOrder;
	}
	public void setSubscriberOrder(AnyProtocolKind subscriberOrder) {
		this.subscriberOrder = subscriberOrder;
	}
	public String getEcontent() {
		return econtent;
	}
	public void setEcontent(String econtent) {
		this.econtent = econtent;
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
