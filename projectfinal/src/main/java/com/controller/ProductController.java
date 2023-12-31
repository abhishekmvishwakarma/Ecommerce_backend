package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ProductDao;
import com.model.Product;
import com.services.ProductService;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "*")
public class ProductController 
{
	@Autowired
	private ProductService productService;

	@Autowired
	private ProductDao productDao;
	
	@PostMapping("/addProductToCategory/{idCategory}")
	Product addProductToCategory(@RequestBody Product product, @PathVariable long idCategory) {
		return productService.addProductToCategory(product, idCategory);
	}

	@PutMapping("/editProduct/{id}")
	Product editProduct(@RequestBody Product product, @PathVariable long id) {
		 return productService.editProduct(product, id);
	}

	@GetMapping("/findProductById/{id}")
	Product findProductById(@PathVariable long id) {
		return productService.findProductById(id);
	}

	@DeleteMapping("/deleteProduct/{id}")
	void deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
	}

	@GetMapping("/findAllProducts")
	List<Product> findAllProducts() {
		return productService.findAllProducts();
	}

	@GetMapping("/findProductsForCategory/{idCategory}")
	List<Product> findProductsForCategory(@PathVariable long idCategory) {
		return productService.findProductsForCategory(idCategory);
	}

	@GetMapping("/findByName/{name}")
	List<Product> findByName(@PathVariable String name) {
		return productDao.findByName("%" + name + "%");
	}

}
