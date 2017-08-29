package com.anyview.action;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkUpdateCmpTimesRequest;
import com.anyview.codec.pojo.response.PkUpdateCmpTimesResponse;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkUpdateCmpTimesManager;

/**
 * 
 * @author 李海峰
 */
@Controller
public class PkUpdateCmpTimesAction {

	PkUpdateCmpTimesRequest  updateCmpTimesmsg;
	String ip;
	int port;
	
	// Spring: 注入bean
		private PkUpdateCmpTimesManager  pkUpdateCmpTimesManager=(PkUpdateCmpTimesManager)SubscribeServerStart.spctx.getBean("pkUpdateCmpTimesManagerImpl");
		
		 PkUpdateCmpTimesResponse builder=new  PkUpdateCmpTimesResponse();
		
		 public PkUpdateCmpTimesAction (PkUpdateCmpTimesRequest updateCmpTimesmsg){
			 this.updateCmpTimesmsg=updateCmpTimesmsg;
			
		 }
		
		 public PkUpdateCmpTimesResponse  PkUpdateCmpTimesResponse() throws Exception{
			 
			 String eid=updateCmpTimesmsg.getEid();
			 int cmpcount=updateCmpTimesmsg.getCmpcount();
			 int cmprightcount=updateCmpTimesmsg.getCmprightcount();
			 int cmperrorcount=updateCmpTimesmsg.getCmperrorcount();
			 String contextid=updateCmpTimesmsg.getContextID();
			 
		pkUpdateCmpTimesManager.updateCmpTimesDao(eid, cmpcount, cmprightcount, cmperrorcount);
			 
		builder.setContextID(contextid);
		builder.setUpdateCmpTimesEnumState(PkUpdateCmpTimesResponse.UpdateCmpTimesEnum.UpdateSuccess);
		return builder;
			 
		 }
		
		
		
		
		
		
		
		
		
		
		
}
