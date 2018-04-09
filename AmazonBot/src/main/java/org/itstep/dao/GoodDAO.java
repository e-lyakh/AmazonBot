package org.itstep.dao;

import org.hibernate.Session;
import org.itstep.model.Good;
import org.itstep.util.HiberUtil;

public class GoodDAO {
	
	private HiberUtil hUtil;
	
	public GoodDAO() {
		hUtil = new HiberUtil();
	}
	
	public void save(Good good) {
		
		Session session = hUtil.getSessionFactory().openSession();		
		session.getTransaction().begin();		
		session.saveOrUpdate(good);		
		session.getTransaction().commit();		
		session.close();
	};
	
	public Good get(String asin) {
		
		Session session = hUtil.getSessionFactory().openSession();		
		session.getTransaction().begin();		
		Good good = session.get(Good.class, asin);		
		session.getTransaction().commit();		
		session.close();		
		return good;
	};
	
	public void delete(Good good) {
		
		Session session = hUtil.getSessionFactory().openSession();		
		session.getTransaction().begin();		
		session.delete(good);		
		session.getTransaction().commit();		
		session.close();
	};

}