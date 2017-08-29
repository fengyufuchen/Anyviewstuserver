package com.anyview.action;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkCustomPrjRequest;
import com.anyview.codec.pojo.response.CustomProject;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkCustomPrjManger;
import com.anyview.codec.pojo.response.PkCustomPrjResponse;

/**
 * 
 * @author 杨坚新
 *
 */
@Controller
public class PkCustomPrjAction {
	PkCustomPrjRequest pkCustomPrjRequest;
	private PkCustomPrjManger pkCustomPrjManger = (PkCustomPrjManger) SubscribeServerStart.spctx
			.getBean("pkCustomPrjManagerImpl");
	// 响应包
	PkCustomPrjResponse builder = new PkCustomPrjResponse();

	public PkCustomPrjAction(PkCustomPrjRequest pkCustomPrjRequest) {
		this.pkCustomPrjRequest = pkCustomPrjRequest;
	}

	/**
	 * 响应pkCustomPrjRequest请求
	 * 
	 * @return
	 */
	public PkCustomPrjResponse pkCustomPrjResponse() {
		int sid = pkCustomPrjRequest.getSid();
		String contextID = pkCustomPrjRequest.getCotextID();
		List<CustomProject> list = pkCustomPrjManger.getCustomPrj(sid);
		builder.setContextID(contextID);
		if (list != null) {
			builder.setCustomPrjState(PkCustomPrjResponse.CustomPrjState.getCustomPrjState);
			builder.setCustomProjects(list);
		} else {
			builder.setCustomPrjState(PkCustomPrjResponse.CustomPrjState.prjNotExist);
		}
		return builder;
	}
}
