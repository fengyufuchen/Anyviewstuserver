package com.anyview.action;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkUpdateCustomFileContentRequest;
import com.anyview.codec.pojo.response.PkUpdateCustomFileContentResponse;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkUpdateCustomFileContentManager;

/**
 * 
 * @author 杨坚新
 *
 */
@Controller
public class PkUpdateCustomFileContentAction {
	PkUpdateCustomFileContentRequest pkUpdateCustomFileRequest;

	private PkUpdateCustomFileContentManager pkUpdateCustomFileManager = (PkUpdateCustomFileContentManager) SubscribeServerStart.spctx
			.getBean("pkUpdateCustomFileContentManagerImpl");

	PkUpdateCustomFileContentResponse builder = new PkUpdateCustomFileContentResponse();

	public PkUpdateCustomFileContentAction(PkUpdateCustomFileContentRequest pkUpdateCustomFileRequest) {
		this.pkUpdateCustomFileRequest = pkUpdateCustomFileRequest;
	}

	public PkUpdateCustomFileContentResponse pkUpdateCmpTimesResponse() {
		String content = pkUpdateCustomFileRequest.getContent();
		String contextID = pkUpdateCustomFileRequest.getCotextID();
		int cfID = pkUpdateCustomFileRequest.getCfID();
		boolean flag = pkUpdateCustomFileManager.updateCustomFileResult(cfID, content);
		builder.setContextID(contextID);
		if (flag) {
			builder.setUpdateCustomFileState(PkUpdateCustomFileContentResponse.UpdateCustomFileState.updateSuccess);
		} else {
			builder.setUpdateCustomFileState(PkUpdateCustomFileContentResponse.UpdateCustomFileState.updateFailure);
		}
		return builder;
	}
}
