package com.anyview.action;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkDeleteCustomFileRequest;
import com.anyview.codec.pojo.response.PkDeleteCustomFileResponse;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkDeleteCustomFileManager;

/**
 * 
 * @author 杨坚新
 *
 */
@Controller
public class PkDeleteCustomFileAction {
	private PkDeleteCustomFileResponse builder = new PkDeleteCustomFileResponse();
	private PkDeleteCustomFileRequest request;
	private PkDeleteCustomFileManager manager = (PkDeleteCustomFileManager) SubscribeServerStart.spctx
			.getBean("pkDeleteCustomFileManagerImpl");

	public PkDeleteCustomFileAction(PkDeleteCustomFileRequest request) {
		this.request = request;
	}

	public PkDeleteCustomFileResponse pkDeleteCustomFileResponse() {
		builder.setContextID(request.getContextID());
		if (manager.deleteCustomFile(request.getCfID())) {
			builder.setDeleteCustomFileState(PkDeleteCustomFileResponse.DeleteCustomFileState.deleteFileSuccess);
		} else {
			builder.setDeleteCustomFileState(PkDeleteCustomFileResponse.DeleteCustomFileState.deleteFileFailure);
		}
		return builder;

	}
}
