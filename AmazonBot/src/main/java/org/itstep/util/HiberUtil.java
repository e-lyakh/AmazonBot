package org.itstep.util;

import java.io.File;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.itstep.model.Account;
import org.itstep.model.Good;
import org.itstep.model.GoodAction;

public class HiberUtil {
	
	private static SessionFactory sessionFactory = createSessionFactory();

	private static SessionFactory createSessionFactory() throws HibernateException {		
		
		Configuration configuration = new Configuration(); // for hibernate.properties
		
		configuration.addAnnotatedClass(Account.class);
		configuration.addAnnotatedClass(Good.class);
		configuration.addAnnotatedClass(GoodAction.class);
		
		//String userDir = System.getProperty("user.dir");
		//Configuration configuration = new Configuration().configure(new File(userDir + "/src/org/itstep/resources/hibernate.cfg.xml"));
		
		return configuration.buildSessionFactory();
		
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}