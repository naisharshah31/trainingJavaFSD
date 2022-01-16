package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.bean.ProductWrapper;
import com.example.demo.exception.RecordNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	public ProductWrapper saveProduct(ProductWrapper inputProduct) {
		
		Product product = new Product();
		
		product.setBrand(inputProduct.getBrand());
		product.setCategory(inputProduct.getCategory());
		product.setColor(inputProduct.getColor());
		product.setCreatedDate(inputProduct.getCreatedDate());
		product.setDiscount(inputProduct.getDiscount());
		product.setPrice(inputProduct.getPrice());
		product.setProductName(inputProduct.getProductName());
		product.setQuantity(inputProduct.getQuantity());
		product.setSeason(inputProduct.getSeason());
		
		
		product = repository.save(product);
		
		inputProduct.setProductID(product.getProductID());
		inputProduct.setBrand(product.getBrand());
		inputProduct.setCategory(product.getCategory());
		inputProduct.setColor(product.getColor());
		inputProduct.setCreatedDate(product.getCreatedDate());
		inputProduct.setDiscount(product.getDiscount());
		inputProduct.setPrice(product.getPrice());
		inputProduct.setProductName(product.getProductName());
		inputProduct.setQuantity(product.getQuantity());
		inputProduct.setSeason(product.getSeason());
		
		return inputProduct;
	}
	
	public ProductWrapper getProductById(Long id) throws RecordNotFoundException {
		
		ProductWrapper productWrapperOutput = null;
		
		Optional<Product> productOptionalData = repository.findById(id);
		if(productOptionalData.isPresent()) {
			productWrapperOutput = new ProductWrapper();
			Product product = productOptionalData.get();
			productWrapperOutput.setProductID(product.getProductID());
			productWrapperOutput.setBrand(product.getBrand());
			productWrapperOutput.setCategory(product.getCategory());
			productWrapperOutput.setColor(product.getColor());
			productWrapperOutput.setCreatedDate(product.getCreatedDate());
			productWrapperOutput.setDiscount(product.getDiscount());
			productWrapperOutput.setPrice(product.getPrice());
			productWrapperOutput.setProductName(product.getProductName());
			productWrapperOutput.setQuantity(product.getQuantity());
			productWrapperOutput.setSeason(product.getSeason());
		} else {
			throw new RecordNotFoundException("Product not found in catelog");
		}
		
		
		return productWrapperOutput;
	}
	
	public ProductWrapper updateProductDetails(ProductWrapper inputProduct) throws RecordNotFoundException {
		
		Optional<Product> productOptionalData = repository.findById(inputProduct.getProductID());
		
		if(productOptionalData.isPresent()) {
			Product product = productOptionalData.get();
			
			//UPDATE the name
			product.setProductName(inputProduct.getProductName());
			repository.save(product);
			
			//Populate the updated details in the output object
			ProductWrapper productWrapperOutput = new ProductWrapper();
			productWrapperOutput.setProductID(product.getProductID());
			productWrapperOutput.setBrand(product.getBrand());
			productWrapperOutput.setCategory(product.getCategory());
			productWrapperOutput.setColor(product.getColor());
			productWrapperOutput.setCreatedDate(product.getCreatedDate());
			productWrapperOutput.setDiscount(product.getDiscount());
			productWrapperOutput.setPrice(product.getPrice());
			productWrapperOutput.setProductName(product.getProductName());
			productWrapperOutput.setQuantity(product.getQuantity());
			productWrapperOutput.setSeason(product.getSeason());
			
			return productWrapperOutput;
		} else {
			throw new RecordNotFoundException("Product not found in catelog");
		}
			
	}
	
	public void deleteProductById(Long id) throws RecordNotFoundException {
		Optional<Product> productOptionalData = repository.findById(id);
		if(productOptionalData.isPresent()) {
			
			Product product = productOptionalData.get();
			repository.delete(product);
		} else {
			throw new RecordNotFoundException("Record not found in catelog");
		}
	}
	
	
}
