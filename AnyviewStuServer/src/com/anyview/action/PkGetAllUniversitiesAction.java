package com.anyview.action;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Controller;

import com.anyview.codec.pojo.response.PkGetAllUniversitiesResponse;
import com.anyview.entities.UniversityTable;
import com.anyview.server.start.SubscribeServerStart;
import com.anyview.service.PkGetAllUniversitiesManager;

@Controller
public class PkGetAllUniversitiesAction {

	// Spring: 注入bean
	private PkGetAllUniversitiesManager pkGetAllUniversitiesManager = (PkGetAllUniversitiesManager) SubscribeServerStart.spctx
			.getBean("pkGetAllUniversitiesManagerImpl");

	public PkGetAllUniversitiesResponse pkGetAllUniversitiesResponse() throws Exception {

		List<UniversityTable> unList = pkGetAllUniversitiesManager.getAllUniversities();

		HashMap<Integer, String> unMap = new HashMap<Integer, String>();

		for (UniversityTable un : unList) {
			unMap.put(un.getUnID(), un.getUnName());
		}

		PkGetAllUniversitiesResponse builder = new PkGetAllUniversitiesResponse();
		
		builder.setUniversities(unMap);

		return builder;

	}

}
