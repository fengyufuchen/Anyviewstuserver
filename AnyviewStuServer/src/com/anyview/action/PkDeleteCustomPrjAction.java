package com.anyview.action;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkDeleteCustomPrjRequest;
import com.anyview.codec.pojo.response.PkDeleteCustomPrjResponse;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkDeleteCustomPrjManager;

/**
 * 
 * @author 杨坚新
 *
 */
@Controller
public class PkDeleteCustomPrjAction {
	PkDeleteCustomPrjRequest request;
	PkDeleteCustomPrjResponse builder = new PkDeleteCustomPrjResponse();
	private PkDeleteCustomPrjManager manager = (PkDeleteCustomPrjManager) SubscribeServerStart.spctx
			.getBean("pkDeleteCustomPrjManagerImpl");

	public PkDeleteCustomPrjAction(PkDeleteCustomPrjRequest request) {
		this.request = request;
	}

	public PkDeleteCustomPrjResponse pkDeleteCustomPrjResponse() {
		String contextID = request.getContextID();
		int cpID = request.getCpID();
		builder.setContextID(contextID);
		if (manager.deleteCustomPrj(cpID)) {
			builder.setDeleteCustomPrjState(PkDeleteCustomPrjResponse.DeleteCustomPrjState.deletePrjSuccess);
		} else {
			builder.setDeleteCustomPrjState(PkDeleteCustomPrjResponse.DeleteCustomPrjState.deletePrjSuccess);
		}
		return builder;
	}
}
