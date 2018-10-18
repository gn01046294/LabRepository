package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;

import util.HibernateUtil;

@Entity
@Table(name = "Product")
public class ProductBean {
	@Id
	private Integer id;// 請注意!盡量用物件型別不要用基本型態int <=>Integer
	private String name;
	private Double price;// 請注意!盡量用物件型別不要用基本型態double <=>Double
	private java.util.Date make;
	private Integer expire;// 請注意!盡量用物件型別不要用基本型態int <=>Integer

	// 測試程式 測試連線是否成功
	public static void main(String[] args) {
		HibernateUtil.getSessionFactory().getCurrentSession().beginTransaction();
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ProductBean selectData = session.get(ProductBean.class, 2);
		System.out.println("selectData = " + selectData);
		HibernateUtil.getSessionFactory().getCurrentSession().getTransaction().commit();
		HibernateUtil.shutdown();
	}
	// 測試程式結束

	@Override
	public String toString() {
		return "ProductBean [id=" + id + ", name=" + name + ", price=" + price + ", make=" + make + ", expire=" + expire
				+ "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public java.util.Date getMake() {
		return make;
	}

	public void setMake(java.util.Date make) {
		this.make = make;
	}

	public Integer getExpire() {
		return expire;
	}

	public void setExpire(Integer expire) {
		this.expire = expire;
	}

}
