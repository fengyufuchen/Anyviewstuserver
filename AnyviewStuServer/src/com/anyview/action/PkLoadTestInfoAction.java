package com.anyview.action;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkLoadTestInfoRequest;
import com.anyview.codec.pojo.response.CatalogInfo;
import com.anyview.codec.pojo.response.LoadTestInfo;
import com.anyview.codec.pojo.response.PkCatalogResponse;
import com.anyview.codec.pojo.response.PkLoadTestInfoResponse;
import com.anyview.codec.pojo.response.PkLogoutResponse;
import com.anyview.codec.pojo.response.PkLoadTestInfoResponse.LoadTestInfoState;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkLoadTestInfoManager;
import com.anyview.service.PkLogoutManager;

/**
 * @author 杨坚新
 */
@Controller
public class PkLoadTestInfoAction {
	PkLoadTestInfoRequest pkLoadTestInfoRequest;

	// Spring: 注入bean
	private PkLoadTestInfoManager pkLoadTestInfoManager = (PkLoadTestInfoManager) SubscribeServerStart.spctx
			.getBean("pkLoadTestInfoManagerImpl");
	// 构造响应包
	PkLoadTestInfoResponse builder = new PkLoadTestInfoResponse();

	public PkLoadTestInfoAction(PkLoadTestInfoRequest pkLoadTestInfoRequest) {
		this.pkLoadTestInfoRequest = pkLoadTestInfoRequest;
	}

	/**
	 * 响应PkLoadTestInfoRequest请求
	 * 
	 * @return
	 */
	public PkLoadTestInfoResponse pkLoadTestInfoResponse() {
		String contextID = pkLoadTestInfoRequest.getCourceID();
		String cid = pkLoadTestInfoRequest.getCid();
		String courceID = pkLoadTestInfoRequest.getCourceID();
		List<LoadTestInfo> testInfo = pkLoadTestInfoManager.getLoadTestInfo(cid, courceID);
		if (testInfo != null) {
			builder.setContextID(contextID);
			builder.setTestInfo(testInfo);
			builder.setLoadTestInfoState(LoadTestInfoState.LoadTestInfoSuccss);
		} else {
			builder.setContextID(contextID);
			builder.setLoadTestInfoState(LoadTestInfoState.LoadTestInfoFailure);
		}
		return builder;
	}
}
