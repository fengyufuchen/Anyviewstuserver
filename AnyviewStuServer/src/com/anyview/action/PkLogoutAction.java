package com.anyview.action;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkLogoutRequest;
import com.anyview.codec.pojo.response.PkLogoutResponse;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkLogoutManager;

/**
 * @author 杨坚新
 */
@Controller
public class PkLogoutAction {

	PkLogoutRequest req;

	// Spring: 注入bean
	private PkLogoutManager pkLogoutManager = (PkLogoutManager) SubscribeServerStart.spctx
			.getBean("pkLogoutManagerImpl");

	PkLogoutResponse builder = new PkLogoutResponse();

	/**
	 * 默认构造器
	 * 
	 * @param req
	 */
	public PkLogoutAction(PkLogoutRequest req) {
		this.req = req;
	}

	public PkLogoutResponse pkLogoutResponse() throws Exception {

		String contextID = req.getContextID();
		String sid = req.getSid();

		boolean studentLoginState = pkLogoutManager.updateStudentLoginState(sid);
		// 注销成功
		if (studentLoginState == true) {
			builder.setLogoutState(PkLogoutResponse.LogoutState.LogoutSuccess);
			builder.setContextID(contextID);
		}
		// 账户未登录，注销失败
		else if (studentLoginState == false) {
			builder.setLogoutState(PkLogoutResponse.LogoutState.NotLogin);
			builder.setContextID(contextID);
		}
		return builder;
	}
}