package com.anyview.service;

import java.util.List;
import java.util.Map;

import com.anyview.codec.pojo.response.CatalogInfo;

/**
 * 
 * @author 杨坚新
 * 
 */
public interface PkCatalogManager {
	public Map<String, List<CatalogInfo>> getCatalogs(String sid, String cid);
}
