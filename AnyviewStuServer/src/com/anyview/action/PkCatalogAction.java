package com.anyview.action;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkCatalogRequest;
import com.anyview.codec.pojo.response.CatalogInfo;
import com.anyview.codec.pojo.response.PkCatalogResponse;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkCatalogManager;

/**
 * 
 * @author 杨坚新
 *
 */
@Controller
public class PkCatalogAction {

	PkCatalogRequest catalogRequest;
	// Spring: 注入bean
	private PkCatalogManager pkCatalogManager = (PkCatalogManager) SubscribeServerStart.spctx
			.getBean("pkCatalogManagerImpl");
	// 构造响应包
	PkCatalogResponse builder = new PkCatalogResponse();

	public PkCatalogAction(PkCatalogRequest catalogRequest) {
		this.catalogRequest = catalogRequest;
	}

	/**
	 * 响应PkCatalogRequest请求
	 * 
	 * @return
	 */
	public PkCatalogResponse pkCatalogResponse() {
		String cid = catalogRequest.getCid();
		String sid = catalogRequest.getSid();
		Map<String, List<CatalogInfo>> catalogs = pkCatalogManager.getCatalogs(sid, cid);
		builder.setContextID(catalogRequest.getContextID());
		if (catalogs != null) {
			builder.setCatalogState(PkCatalogResponse.CatalogState.getCatalogSuccess);
			builder.setCatalogs(catalogs);
		} else {
			builder.setCatalogState(PkCatalogResponse.CatalogState.catalogNotExist);
		}
		return builder;
	}
}
