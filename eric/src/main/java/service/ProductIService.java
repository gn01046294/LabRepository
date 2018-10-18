package service;

import java.util.List;

import model.ProductBean;

public interface ProductIService {

	List<ProductBean> select(ProductBean bean);

	ProductBean insert(ProductBean bean);

	ProductBean update(ProductBean bean);

	boolean delete(ProductBean bean);

}