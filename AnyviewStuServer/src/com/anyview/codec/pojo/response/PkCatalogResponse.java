package com.anyview.codec.pojo.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author 杨坚新
 *
 */
public class PkCatalogResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	// key：计划表名称，value：包含虚拟目录和题目名称的一个类
	private Map<String, List<CatalogInfo>> catalogs;
	private String contextID;
	private CatalogState catalogState;

	public enum CatalogState {
		// 获取目录成功
		getCatalogSuccess,
		// 没有目录存在
		catalogNotExist
	}

	public CatalogState getCatalogState() {
		return catalogState;
	}

	public void setCatalogState(CatalogState catalogState) {
		this.catalogState = catalogState;
	}

	public Map<String, List<CatalogInfo>> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(Map<String, List<CatalogInfo>> catalogs) {
		this.catalogs = catalogs;
	}

	public String getContextID() {
		return contextID;
	}

	public void setContextID(String contextID) {
		this.contextID = contextID;
	}

	@Override
	public String toString() {
		return "PkCatalogResponse [catalogs=" + catalogs + ", contextID=" + contextID + ", catalogState=" + catalogState
				+ "]";
	}

}
