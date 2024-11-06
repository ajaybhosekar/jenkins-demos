package demos.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demos.springboot.entity.Product;
import demos.springboot.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product addProduct(Product product) {
		
		return repository.save(product);
		
	}
	
	public List<Product> getAllProducts() {
		
		List<Product> products = new ArrayList<Product>();
 		Iterable<Product> it = repository.findAll();
		it.forEach(products::add);
		return products;
	}
	
	public Product findById(int id) {
		
		return repository.findById(id).get();
	}

}
