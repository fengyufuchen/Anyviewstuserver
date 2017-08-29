package com.anyview.action;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkUpdateCustomPrjNameRequest;
import com.anyview.codec.pojo.response.PkUpdateCustomPrjNameResponse;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkUpdateCustomPrjNameManager;

/**
 * 
 * @author 杨坚新
 *
 */
@Controller
public class PkUpdateCustomPrjNameAction {
	private PkUpdateCustomPrjNameResponse builder = new PkUpdateCustomPrjNameResponse();
	private PkUpdateCustomPrjNameRequest request;
	private PkUpdateCustomPrjNameManager manager = (PkUpdateCustomPrjNameManager) SubscribeServerStart.spctx
			.getBean("pkUpdateCustomPrjNameManagerImpl");

	public PkUpdateCustomPrjNameAction(PkUpdateCustomPrjNameRequest request) {
		this.request = request;
	}

	public PkUpdateCustomPrjNameResponse pkUpdateCustomPrjNameResponse() {
		builder.setContextID(request.getContextID());
		boolean flag = manager.updateCustomPrjName(request.getCpID(), request.getCpName());
		if (flag) {
			builder.setPkUpdateCustomPrjNameState(
					PkUpdateCustomPrjNameResponse.PkUpdateCustomPrjNameState.updatePrjNameSuccess);
		} else {
			builder.setPkUpdateCustomPrjNameState(
					PkUpdateCustomPrjNameResponse.PkUpdateCustomPrjNameState.updatePrjNameFailure);
		}
		return builder;

	}
}
