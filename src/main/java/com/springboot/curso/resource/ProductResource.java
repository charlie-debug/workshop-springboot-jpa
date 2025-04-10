package com.springboot.curso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.curso.entities.Product;
import com.springboot.curso.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	@Autowired
	private ProductService ProductSevice;

	@GetMapping
	public ResponseEntity<List<Product>> findAll() {
	 List<Product> list = ProductSevice.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id){
		Product obj = ProductSevice.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
