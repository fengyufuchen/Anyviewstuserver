package com.anyview.dao;

import java.util.List;
import java.util.Map;

import com.anyview.codec.pojo.response.CatalogInfo;

/**
 * 
 * @author 杨坚新
 * 
 */
public interface PkCatalogDao {
//	public Map<String, List<CatalogInfo>> getCatalogs(String sid, String cid);

	public List<Map<Integer, String>> getVidAndVName(String cid);

	public List<CatalogInfo> getCatalog(Integer vid,String sid,String cid);
}
