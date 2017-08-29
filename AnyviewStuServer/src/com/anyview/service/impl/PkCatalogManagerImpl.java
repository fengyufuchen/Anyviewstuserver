package com.anyview.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anyview.codec.pojo.response.CatalogInfo;
import com.anyview.dao.PkCatalogDao;
import com.anyview.service.PkCatalogManager;

/**
 * 
 * @author 杨坚新
 * 
 */
@Service
public class PkCatalogManagerImpl implements PkCatalogManager {
	@Autowired
	private PkCatalogDao pkCatalogDao;

	@Override
	public Map<String, List<CatalogInfo>> getCatalogs(String sid, String cid) {
		Map<String, List<CatalogInfo>> catalogInfos = new HashMap<>();
		List<Map<Integer, String>> list = pkCatalogDao.getVidAndVName(cid);
		for (Map map : list) {
			String vname = (String) map.get("vname");
			int vid = (int) map.get("vid");
			System.out.println("vid=" + vid);
			System.out.println("vname=" + vname);
			List<CatalogInfo> catalogs = pkCatalogDao.getCatalog(vid, sid, cid);
			catalogInfos.put(vname, catalogs);
		}
		return catalogInfos;
	}

}
