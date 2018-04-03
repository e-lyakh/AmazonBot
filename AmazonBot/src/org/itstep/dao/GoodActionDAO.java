package org.itstep.dao;

import org.hibernate.Session;
import org.itstep.model.GoodAction;
import org.itstep.util.HiberUtil;

public class GoodActionDAO {
	
	public static void save(GoodAction goodAction) {
		
		Session session = HiberUtil.getSessionFactory().openSession();		
		session.getTransaction().begin();		
		session.saveOrUpdate(goodAction);		
		session.getTransaction().commit();		
		session.close();
	};
	
	public static GoodAction get(Integer id) {
		
		Session session = HiberUtil.getSessionFactory().openSession();		
		session.getTransaction().begin();		
		GoodAction goodAction = session.get(GoodAction.class, id);		
		session.getTransaction().commit();		
		session.close();		
		return goodAction;
	};
	
	public static void delete(GoodAction goodAction) {
		
		Session session = HiberUtil.getSessionFactory().openSession();		
		session.getTransaction().begin();		
		session.delete(goodAction);		
		session.getTransaction().commit();		
		session.close();
	};

}
