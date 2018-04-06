package org.itstep.dao;

import org.hibernate.Session;
import org.itstep.model.Good;
import org.itstep.util.HiberUtil;

public class GoodDAO {
	
	public static void save(Good good) {
		
		Session session = HiberUtil.getSessionFactory().openSession();		
		session.getTransaction().begin();		
		session.saveOrUpdate(good);		
		session.getTransaction().commit();		
		session.close();
	};
	
	public static Good get(String asin) {
		
		Session session = HiberUtil.getSessionFactory().openSession();		
		session.getTransaction().begin();		
		Good good = session.get(Good.class, asin);		
		session.getTransaction().commit();		
		session.close();		
		return good;
	};
	
	public static void delete(Good good) {
		
		Session session = HiberUtil.getSessionFactory().openSession();		
		session.getTransaction().begin();		
		session.delete(good);		
		session.getTransaction().commit();		
		session.close();
	};

}