package org.itstep.dao;

import org.hibernate.Session;
import org.itstep.model.GoodAction;
import org.itstep.util.HiberUtil;

public class GoodActionDAO {
	
	private HiberUtil hUtil;
	private Session session;
	
	public GoodActionDAO() {
		hUtil = new HiberUtil();
	}
	
	public void save(GoodAction goodAction) {
		
		session = hUtil.getSessionFactory().openSession();		
		session.getTransaction().begin();		
		session.saveOrUpdate(goodAction);		
		session.getTransaction().commit();		
		session.close();
	};
	
	public GoodAction get(Integer id) {
		
		session = hUtil.getSessionFactory().openSession();		
		session.getTransaction().begin();		
		GoodAction goodAction = session.get(GoodAction.class, id);		
		session.getTransaction().commit();		
		session.close();		
		return goodAction;
	};
	
	public void delete(GoodAction goodAction) {
		
		session = hUtil.getSessionFactory().openSession();		
		session.getTransaction().begin();		
		session.delete(goodAction);		
		session.getTransaction().commit();		
		session.close();
	};

}
