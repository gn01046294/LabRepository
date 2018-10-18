package service;

import java.util.ArrayList;
import java.util.List;

import model.ProductBean;
import model.ProductIDAO;

public class ProductService implements ProductIService {

	public ProductIDAO productIDAO;

	public ProductService(ProductIDAO productIDAO) {
		this.productIDAO = productIDAO;
	} 
	
	@Override
	public List<ProductBean> select(ProductBean bean) {
		List<ProductBean> result = null;
		if(bean!=null && bean.getId()!=0) {
			ProductBean temp = productIDAO.select(bean.getId());
			if(temp!=null) {
				result = new ArrayList<ProductBean>();
				result.add(temp);
			}
		} else {
			result = productIDAO.select(); 
		}
		return result;
	}
	@Override
	public ProductBean insert(ProductBean bean) {
		ProductBean result = null;
		if(bean!=null) {
			result = productIDAO.insert(bean);
		}
		return result;
	}
	@Override
	public ProductBean update(ProductBean bean) {
		ProductBean result = null;
		if(bean!=null) {
			result = productIDAO.update(bean.getName(), bean.getPrice(),
					bean.getMake(), bean.getExpire(), bean.getId());
		}
		return result;
	}
	@Override
	public boolean delete(ProductBean bean) {
		boolean result = false;
		if(bean!=null) {
			result = productIDAO.delete(bean.getId());
		}
		return result;
	}
}
