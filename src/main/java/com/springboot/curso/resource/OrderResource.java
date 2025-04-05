package com.springboot.curso.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.curso.entities.Order;
import com.springboot.curso.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {
	@Autowired
	private OrderService OrderSevice;

	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
	 List<Order> list = OrderSevice.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id){
		Order obj = OrderSevice.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
