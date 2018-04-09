package org.itstep.dao;

import org.hibernate.Session;
import org.itstep.model.Account;
import org.itstep.util.HiberUtil;

public class AccountDAO {
	
	private HiberUtil hUtil;
	private Session session;
	
	public AccountDAO() {
		hUtil = new HiberUtil();
	}
	
	public void save(Account account) {		
		
		session = hUtil.getSessionFactory().openSession();
		session.getTransaction().begin();		
		session.saveOrUpdate(account);		
		session.getTransaction().commit();		
		session.close();
	};
	
	public Account get(String email) {		
		
		session = hUtil.getSessionFactory().openSession();	
		session.getTransaction().begin();		
		Account account = session.get(Account.class, email);		
		session.getTransaction().commit();		
		session.close();		
		return account;
	};
	
	public void delete(Account account) {		
		
		session = hUtil.getSessionFactory().openSession();	
		session.getTransaction().begin();		
		session.delete(account);
		session.getTransaction().commit();		
		session.close();
	};

}