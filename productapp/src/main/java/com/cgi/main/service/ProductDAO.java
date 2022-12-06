package com.cgi.main.service;

import java.util.List;

import com.cgi.main.exception.ProductNotFoundException;
import com.cgi.main.model.Product;

public interface ProductDAO {

	public Product saveProduct(Product product);
	public Product getProductById(int id) throws ProductNotFoundException;
	public List<Product> getAllProducts();
	public boolean deleteProductById(int id);
	public Product updateProduct(Product product);
}
