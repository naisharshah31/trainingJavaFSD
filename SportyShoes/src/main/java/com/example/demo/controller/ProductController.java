package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.bean.ProductWrapper;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;

	@PostMapping("/saveProduct")
	public ResponseEntity<ProductWrapper> saveProduct (@RequestBody ProductWrapper productWrapper) {
		productWrapper = productService.saveProduct(productWrapper);
		return ResponseEntity.ok(productWrapper);
	}
	
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<ProductWrapper> getProductById (@PathVariable Long id) throws RecordNotFoundException {
		ProductWrapper productWrapper = productService.getProductById(id);
		return ResponseEntity.ok(productWrapper);
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<ProductWrapper> updateProduct (@RequestBody ProductWrapper productWrapper) throws RecordNotFoundException {
		productWrapper = productService.updateProductDetails(productWrapper);
		return ResponseEntity.ok(productWrapper);
	}
	
	@DeleteMapping("deleteProduct/{id}")
	public ResponseEntity<ProductWrapper> deleteProductById (@PathVariable Long id) throws RecordNotFoundException {
		productService.deleteProductById(id);
		return ResponseEntity.noContent().build();
	}
	
	
}
