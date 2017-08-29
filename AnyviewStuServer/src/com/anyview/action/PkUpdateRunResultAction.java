package com.anyview.action;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkUpdateRunResultRequest;
import com.anyview.codec.pojo.response.PkUpdateRunResultResponse;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkUpdateRunResultManager;

/**
 * 
 * @author 李海峰
 */
@Controller
public class PkUpdateRunResultAction {
	
	PkUpdateRunResultRequest updateRunResultmsg;
	String ip;
	int port;
	
	// Spring: 注入bean
	private PkUpdateRunResultManager pkUpdateRunResult=(PkUpdateRunResultManager)SubscribeServerStart.spctx.getBean("pkUpdateRunResultManagerImpl");

	PkUpdateRunResultResponse builder=new PkUpdateRunResultResponse();
	
	public PkUpdateRunResultAction(PkUpdateRunResultRequest updateRunResultmsg){
           this.updateRunResultmsg = updateRunResultmsg;
           
              }
	
	public PkUpdateRunResultResponse PkUpdateRunResultResponse() throws Exception {
		
		String eid=updateRunResultmsg.getEid();
		int runresult=updateRunResultmsg.getRunresult();
		int runerrcount=updateRunResultmsg.getRunerrcount();
		String contextid=updateRunResultmsg.getContextID();
		
		pkUpdateRunResult.updateRunResult(eid, runresult, runerrcount);
		
		
		builder.setContextID(contextid);
		builder.setUpdateRunResultEnumState(PkUpdateRunResultResponse.UpdateRunResultEnum.UpdateSuccess);
		
	    return builder;
		
	}
	
	
	
	
	
	
	
	
	
}
