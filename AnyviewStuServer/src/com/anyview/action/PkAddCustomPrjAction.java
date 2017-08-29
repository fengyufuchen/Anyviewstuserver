package com.anyview.action;

import java.util.Map;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkAddCustomPrjRequest;
import com.anyview.codec.pojo.response.PkAddCustomPrjResponse;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkAddCustomPrjManager;

/**
 * 
 * 
 * @author 杨坚新
 *
 */
@Controller
public class PkAddCustomPrjAction {
	private PkAddCustomPrjRequest request;
	private PkAddCustomPrjResponse builder = new PkAddCustomPrjResponse();
	private PkAddCustomPrjManager manager = (PkAddCustomPrjManager) SubscribeServerStart.spctx
			.getBean("pkAddCustomPrjManagerImpl");

	public PkAddCustomPrjAction(PkAddCustomPrjRequest request) {
		this.request = request;
	}

	public PkAddCustomPrjResponse pkAddCustomPrjResponse() {
		builder.setContextID(request.getContextID());
		Map<String, Integer> idMap = manager.addCustomPrj(request.getCpName(), request.getSid(), request.getCourseID());
		if (idMap.isEmpty()) {
			builder.setPkAddCustomPrjState(PkAddCustomPrjResponse.PkAddCustomPrjState.addPrjFailure);
		} else {
			builder.setPkAddCustomPrjState(PkAddCustomPrjResponse.PkAddCustomPrjState.addPrjSuccess);
		}
		builder.setCpID(idMap.get("cpID"));
		builder.setHeadCfID(idMap.get("headID"));
		builder.setSourceCfID(idMap.get("sourceID"));
		return builder;
	}
}
