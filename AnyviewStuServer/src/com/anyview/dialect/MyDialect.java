package com.anyview.dialect;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQL5Dialect;

public class MyDialect extends MySQL5Dialect {
	public MyDialect() {
		super();
		registerHibernateType(-1, Hibernate.STRING.getName());
	}
}
