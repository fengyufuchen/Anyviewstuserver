package com.anyview.action;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkUpdateCustomFileNameRequest;
import com.anyview.codec.pojo.response.PkUpdateCustomFileNameResponse;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkUpdateCustomFileNameManager;
/**
 * 
 * @author 杨坚新
 *
 */
@Controller
public class PkUpdateCustomFileNameAction {
	private PkUpdateCustomFileNameResponse builder = new PkUpdateCustomFileNameResponse();
	private PkUpdateCustomFileNameRequest request;
	private PkUpdateCustomFileNameManager manager = (PkUpdateCustomFileNameManager) SubscribeServerStart.spctx
			.getBean("pkUpdateCustomFileNameManagerImpl");

	public PkUpdateCustomFileNameAction(PkUpdateCustomFileNameRequest request) {
		this.request = request;
	}

	public PkUpdateCustomFileNameResponse pkUpdateCustomFileNameResponse() {
		builder.setContextID(request.getContextID());
		boolean flag = manager.updateCustomFileName(request.getCfID(), request.getCfName());
		if (flag) {
			builder.setPkUpdateCustomFileNameState(
					PkUpdateCustomFileNameResponse.PkUpdateCustomFileNameState.updateFileNameSuccess);
		} else {
			builder.setPkUpdateCustomFileNameState(
					PkUpdateCustomFileNameResponse.PkUpdateCustomFileNameState.updateFileNameFailure);
		}
		return builder;

	}
}
