package org.itstep.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.itstep.model.Account;
import org.itstep.model.Good;
import org.itstep.model.GoodAction;

public class HiberUtil {
	
	private static SessionFactory sessionFactory = createSessionFactory();

	private static SessionFactory createSessionFactory() {		
		
		Configuration configuration = new Configuration(); // .configure() - for xml
		
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Good.class);
		configuration.addAnnotatedClass(GoodAction.class);
		
		return configuration.buildSessionFactory();
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}