package demos.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demos.springboot.entity.Product;
import demos.springboot.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		
		Product prodAdded = service.addProduct(product);
		return ResponseEntity.ok(prodAdded);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		
		List<Product> productsFromDB = service.getAllProducts();
		
		return ResponseEntity.ok(productsFromDB);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable int id) {
		
		Product prodFromDB = service.findById(id);
		return ResponseEntity.ok(prodFromDB);
	}

}
