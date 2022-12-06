package com.cgi.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.main.exception.ProductNotFoundException;
import com.cgi.main.model.Product;
import com.cgi.main.repository.ProductRepository;

@Service
public class ProductService implements ProductDAO {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {

		return this.productRepository.save(product);
	}

	@Override
	public Product getProductById(int id) {
		/*Optional<Product> op = this.productRepository.findById(id);
		if (op.isPresent()) {
			return op.get();
		} else {
			throw new ProductNotFoundException("PRODUCT NOT FOUND");
		}*/
		return this.productRepository.findById(id)
				.orElseThrow(()->new ProductNotFoundException("PRODUCT NOT FOUND:"+id));

	}

	@Override
	public List<Product> getAllProducts() {
		 return this.productRepository.findAll();
	}

	@Override
	public boolean deleteProductById(int id) {
		this.productRepository.deleteById(id);
		return true;
	}

	@Override
	public Product updateProduct(Product product) {
		return this.productRepository.save(product);
	}

}
