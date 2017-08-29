package com.anyview.action;

import java.util.Map;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkGetClassRequest;
import com.anyview.codec.pojo.response.PkGetClassResponse;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkGetClassManager;

@Controller
public class PkGetClassAction {
	private PkGetClassResponse builder = new PkGetClassResponse();
	private PkGetClassRequest request;
	private PkGetClassManager manager = (PkGetClassManager) SubscribeServerStart.spctx.getBean("pkGetClassManagerImpl");

	public PkGetClassAction(PkGetClassRequest request) {
		this.request = request;
	}

	public PkGetClassResponse pkGetClassResponse() {
		builder.setContextID(request.getContextID());
		Map<Integer, String> classes = manager.pkGetClasses(request.getUnid(), request.getSno());
		if (classes.size() != 0 && classes != null) {
			builder.setState(PkGetClassResponse.PkGetClassState.getClassesSuccess);
			builder.setClasses(classes);
		} else {
			builder.setState(PkGetClassResponse.PkGetClassState.ClassNotExist);
		}
		return builder;

	}

}
