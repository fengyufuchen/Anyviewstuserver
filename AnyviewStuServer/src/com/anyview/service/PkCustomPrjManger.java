package com.anyview.service;

import java.util.List;

import com.anyview.codec.pojo.response.CustomProject;

/**
 * 
 * @author 杨坚新
 *
 */
public interface PkCustomPrjManger {
	public List<CustomProject> getCustomPrj(int sid);
}
