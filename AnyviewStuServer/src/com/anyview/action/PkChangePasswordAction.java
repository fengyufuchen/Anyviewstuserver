package com.anyview.action;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkChangePasswordRequest;
import com.anyview.codec.pojo.response.PkChangePasswordResponse;
import com.anyview.entities.StudentTable;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkChangePasswordManager;
/**
 * 
 * @author 李海峰
 *
 */
@Controller
public class PkChangePasswordAction {
	
	PkChangePasswordRequest req;
	String ip;
	int port;
	
	// Spring: 注入bean
	private PkChangePasswordManager pkChangePasswordManager = (PkChangePasswordManager) SubscribeServerStart.spctx.getBean("pkChangePasswordManagerImpl");
	
	PkChangePasswordResponse builder = new PkChangePasswordResponse();
	
	/**
	 * 默认构造器
	 * @param req
	 */
	public PkChangePasswordAction(PkChangePasswordRequest req){
		this.req = req;
		
	}
	
	public PkChangePasswordResponse pkChangePasswordResponse() throws Exception {
		int Sid=req.getSid();
		String OldSPsw=req.getOldSPsw();
		String NewSPsw=req.getNewSPsw();
		String ContextID=req.getContextID();
				
		List<StudentTable> stuList = 
				pkChangePasswordManager.getStudentInfo(Sid);
		
		StudentTable stu = (StudentTable) stuList.get(0);
		
		if( ! OldSPsw.equals(stu.getSpsw())) {
			//Failure ：密码错误
			builder.setChangePswEnumState(PkChangePasswordResponse.ChangePswEnum.OldPwdError);
		} else {
			// Success:旧密码正确
			pkChangePasswordManager.setnewPassword(Sid, NewSPsw);
			builder.setChangePswEnumState(PkChangePasswordResponse.ChangePswEnum.PwdChangeSuccess);
		}
		builder.setContextID(ContextID);
		return builder;
	}
	
}
