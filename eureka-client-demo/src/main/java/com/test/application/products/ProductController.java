package com.test.application.products;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.application.dto.Product;

@RestController
public class ProductController {

	
	@GetMapping(value = "/")
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("1", "Pen"));
		products.add(new Product("2", "Pencil"));
		return products;
	}
}
