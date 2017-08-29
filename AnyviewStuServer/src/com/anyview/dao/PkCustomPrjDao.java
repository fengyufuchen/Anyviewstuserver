package com.anyview.dao;

import java.util.List;

import com.anyview.codec.pojo.response.CustomProject;

/**
 * 
 * @author 杨坚新
 *
 */
public interface PkCustomPrjDao {
	public List<CustomProject> getCustomPrj(int sid);
}
