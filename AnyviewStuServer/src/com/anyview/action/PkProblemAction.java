package com.anyview.action;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkProblemRequest;
import com.anyview.codec.pojo.response.PkProblemResponse;
import com.anyview.entities.ProblemTable;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkProblemManager;

/**
 * 
 * @author 杨坚新
 *
 */
@Controller
public class PkProblemAction {
	PkProblemRequest pkProblemRequest;
	private PkProblemManager pkProblemManager = (PkProblemManager) SubscribeServerStart.spctx
			.getBean("pkProblemManagerImpl");
	PkProblemResponse pkProblemResponse = new PkProblemResponse();

	public PkProblemAction(PkProblemRequest pkProblemRequest) {
		this.pkProblemRequest = pkProblemRequest;
	}

	public PkProblemResponse pkProblemResponse() {
		String pid = pkProblemRequest.getPid();
		String contextID = pkProblemRequest.getContextID();
		ProblemTable problemTable = pkProblemManager.getPContent(pid);
		if (problemTable != null) {
			pkProblemResponse.setProblemState(PkProblemResponse.ProblemState.getproblemSuccess);
			pkProblemResponse.setContextID(contextID);
			pkProblemResponse.setpContent(problemTable.getPcontent());
			pkProblemResponse.setPid(problemTable.getPid());
			pkProblemResponse.setpName(problemTable.getPname());
		} else
			pkProblemResponse.setProblemState(PkProblemResponse.ProblemState.problemCotentIsNull);
		return pkProblemResponse;
	}
}
