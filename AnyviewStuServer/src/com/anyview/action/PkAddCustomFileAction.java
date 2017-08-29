package com.anyview.action;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkAddCustomFileRequest;
import com.anyview.codec.pojo.response.PkAddCustomFileResponse;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkAddCustomFileManager;

/**
 * 
 * 
 * @author 杨坚新
 *
 */
@Controller
public class PkAddCustomFileAction {
	private PkAddCustomFileResponse builder = new PkAddCustomFileResponse();
	private PkAddCustomFileRequest request;
	private PkAddCustomFileManager manager = (PkAddCustomFileManager) SubscribeServerStart.spctx
			.getBean("pkAddCustomFileManagerImpl");

	public PkAddCustomFileAction(PkAddCustomFileRequest request) {
		this.request = request;
	}

	public PkAddCustomFileResponse pkAddCustomFileResponse() {
		builder.setContextID(request.getContextID());
		int cfID = manager.addCustomFile(request.getCpID(), request.getCfName(), request.getContent());
		if (cfID < 0) {
			builder.setPkAddCustomFileState(PkAddCustomFileResponse.PkAddCustomFileState.addFileFailure);
		} else {
			builder.setCfID(cfID);
			builder.setPkAddCustomFileState(PkAddCustomFileResponse.PkAddCustomFileState.addFileSuccess);
		}
		return builder;
	}
}
