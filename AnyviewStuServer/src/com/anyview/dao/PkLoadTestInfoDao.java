package com.anyview.dao;

import java.util.List;
import java.util.Map;

import com.anyview.codec.pojo.response.CatalogInfo;
import com.anyview.codec.pojo.response.LoadTestInfo;
/**
 * 
 * @author 杨坚新
 *
 */
public interface PkLoadTestInfoDao {
	public List<LoadTestInfo> getLoadTestInfo(String cid,String courceID);
}
