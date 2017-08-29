package com.anyview.action;

import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.request.PkGetExerciseContentRequest;
import com.anyview.codec.pojo.response.PkGetExerciseContentResponse;
import com.anyview.entities.ExerciseTable;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkGetExerciseContentManager;

@Controller
public class PkGetExerciseContentAction {
	private PkGetExerciseContentRequest request;
	private PkGetExerciseContentResponse builder = new PkGetExerciseContentResponse();

	private PkGetExerciseContentManager manager = (PkGetExerciseContentManager) SubscribeServerStart.spctx
			.getBean("pkGetExerciseContentManagerImpl");

	public PkGetExerciseContentAction(PkGetExerciseContentRequest request) {
		this.request = request;
	}

	public PkGetExerciseContentResponse pkGetExerciseContentResponse() {
		builder.setContextID(request.getContexID());
		ExerciseTable exercise = manager.getExercise(request.getEid());
		if (exercise != null) {
			builder.setState(PkGetExerciseContentResponse.GetExerciseContentState.getExerciseContentSuccess);
			builder.setContent(exercise.getEcontent());
			builder.setPid(exercise.getProblem().getPid());
			builder.setpName(exercise.getProblem().getPname());
		} else
			builder.setState(PkGetExerciseContentResponse.GetExerciseContentState.exerciseContentIsNull);
		return builder;
	}
}
