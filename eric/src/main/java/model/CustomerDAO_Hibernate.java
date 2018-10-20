package model;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import util.HibernateUtil;

@Repository
public class CustomerDAO_Hibernate implements CustomerIDAO {

	SessionFactory sessionFactory;

	public CustomerDAO_Hibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	// 測試程式開始
//	public static void main(String[] args) {
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		CustomerDAO_Hibernate cdao = new CustomerDAO_Hibernate(HibernateUtil.getSessionFactory());
//		CustomerBean cb = cdao.select("Dave");
//		System.out.println(cb);
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.shutdown();
//	}
	// 測試程式結束

	@Override
	public CustomerBean select(String custid) {
		CustomerBean cb = this.getSession().get(CustomerBean.class, custid);
		return cb;
	}

	@Override
	public boolean update(byte[] password, String email, Date birth, String custid) {
		CustomerBean cb = this.getSession().get(CustomerBean.class, "Dave");
		if (cb != null) {
			cb.setPassword(password);
			cb.setEmail(email);
			cb.setBirth(birth);
			return true;
		}
		return false;
	}
}
