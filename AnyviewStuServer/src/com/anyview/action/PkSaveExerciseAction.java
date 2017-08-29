package com.anyview.action;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkSaveExerciseRequest;
import com.anyview.codec.pojo.response.PkSaveExerciseResponse;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkSaveExerciseManager;

/**
 * 
 * @author 李海峰
 */
@Controller
public class PkSaveExerciseAction {
	PkSaveExerciseRequest  pkSaveExercisemsg;
	String ip;
	int port;
	
	// Spring: 注入bean
	private PkSaveExerciseManager pkSaveExerciseManager=(PkSaveExerciseManager)SubscribeServerStart.spctx.getBean("pkSaveExerciseManagerImpl");
			
	PkSaveExerciseResponse builder=new  PkSaveExerciseResponse();
	
	 public PkSaveExerciseAction (PkSaveExerciseRequest pkSaveExercisemsg){
		 this.pkSaveExercisemsg=pkSaveExercisemsg;
		
	 }
	 
	 public PkSaveExerciseResponse  PkSaveExerciseResponse() throws Exception{
		 
		 String eid=pkSaveExercisemsg.getEid();
		String econtent=pkSaveExercisemsg.getEcontent();
		 String contextid=pkSaveExercisemsg.getContextID();
		 
		 pkSaveExerciseManager.SaveExerciseDao(eid, econtent);
		 
		 builder.setContextID(contextid);
		 builder.setSaveExerciseEnumState(PkSaveExerciseResponse.SaveExerciseEnum.SaveSuccess);
		 
		return builder;
		 
		 
		 
	 }
	
	
	
	
	
	
	
	
	
	
	

}
