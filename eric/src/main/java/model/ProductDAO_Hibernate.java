package model;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.sun.org.apache.regexp.internal.recompile;

import util.HibernateUtil;


@Repository
public class ProductDAO_Hibernate implements ProductIDAO {

	SessionFactory sessionFactory;
	
	public ProductDAO_Hibernate (SessionFactory sessionFactory) {
		this.sessionFactory=sessionFactory;
	}
	
	public Session getSession() {
		Session session = this.sessionFactory.getCurrentSession();
		return session;
	}
	
	//測試程式開始
//	public static void main(String[] args) {
//		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
//		ProductDAO_Hibernate pdao = new ProductDAO_Hibernate(HibernateUtil.getSessionFactory());
//		System.out.println();
//		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
//		HibernateUtil.shutdown();
//	}
	//測試程式結束
	
	@Override
	public ProductBean select(int id) {
		ProductBean pb = this.getSession().get(ProductBean.class, id);
		return pb;
	}

	@Override
	public List<ProductBean> select() {
		List<ProductBean> list = null;
		Session session = this.getSession();
		 list = session.createQuery("FROM ProductBean",ProductBean.class).setMaxResults(50).list();
		return list;
	}

	@Override
	public ProductBean insert(ProductBean bean) {
		if(bean!=null) {
			ProductBean temp=this.getSession().get(ProductBean.class, bean.getId());
			if(temp==null) {
				this.getSession().save(bean);
				return bean;
			}
		}
		return null;
	}

	@Override
	public ProductBean update(String name, double price, Date make, int expire, int id) {
		ProductBean temp = this.getSession().get(ProductBean.class, id);
		if(temp!=null) {
			temp.setName(name);
			temp.setPrice(99.9);
			temp.setMake(make);
			temp.setExpire(expire);
		}
		return temp;
	}

	@Override
	public boolean delete(int id) {
		ProductBean temp = this.getSession().get(ProductBean.class, id);
	if(temp!=null) {
	     this.getSession().delete(temp);
	     return true;
	}
		
		return false;
	}
}
