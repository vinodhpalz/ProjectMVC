package com.model;

import java.util.List;

public interface IProductDAO {

	boolean insertProduct(Product p);
	List<Product> getProducts();

}