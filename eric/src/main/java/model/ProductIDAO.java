package model;

import java.util.List;

public interface ProductIDAO {

	public ProductBean select(int id);
	
	public List<ProductBean> select();
	
	public ProductBean insert(ProductBean bean);
	
	public ProductBean update(String name, double price, java.util.Date make, int expire, int id);
	
	public boolean delete(int id);
	
}
