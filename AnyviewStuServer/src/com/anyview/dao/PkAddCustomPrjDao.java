package com.anyview.dao;

import java.util.Map;

/**
 * 
 * 
 * @author 杨坚新
 *
 */
public interface PkAddCustomPrjDao {
	public Map<String, Integer> addCustomPrj(String cpName, int sid, int courseID);
}
