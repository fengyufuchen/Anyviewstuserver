package com.anyview.dao;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

public interface BaseDao {

	public SessionFactory getSessionFactory();
	
	/**Spring注入sessionFactory*/
	public void setSessionFactory(SessionFactory sessionFactory);
	
	/**
	 * 
	 * @Description: TODO(查询数量) 
	 * @param criteria
	 * @return
	 * @author 何凡 <piaobo749@qq.com>
	 * @date 2015年11月8日 下午9:17:30
	 */
	public Integer getCount(final DetachedCriteria criteria);
}
