package com.product.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.entity.Product;
import com.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping("/home")
	public String homePage() {
		return "index";
	}
	
//	@GetMapping("/register")
//	public String registerUser(Model model) {
//		model.addAttribute("user", new User());
//		return "registeration form";
//	}

	@GetMapping("/all")
	public List<Product> list(){
		return productService.listAll();
	}
	@GetMapping("/get/id/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id) {
		try {
			Product product = productService.getProduct(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/get/name/{name}")
	public ResponseEntity<List<Product>> getProductsByName(@PathVariable String name) {
		try {
			List<Product> products = productService.getProductsByName(name);
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		catch(NoSuchElementException e){
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/add")
		public String addProduct(@RequestBody Product product) {
		productService.addProduct(product);
		return "produuct successfully added";
	}
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product, @PathVariable int id){
		Product resp = productService.updateProduct(product, id);
		return new ResponseEntity<Product>(resp, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id) {
		return productService.deleteProduct(id);
	}
	
	@PostMapping("/quantity/{id}/{quantity}")
	public ResponseEntity<Product> manageQuantity(@PathVariable("id") int id,@PathVariable("quantity") int updatedQuantity) {
		Product resp = productService.manageQuantity(id, updatedQuantity);
		if(resp.getId()!=0) {
			return new ResponseEntity<Product>(resp,HttpStatus.OK);
		}
		return  new ResponseEntity<Product>(resp,HttpStatus.CONFLICT);
		
	}
	@GetMapping("/isAvailable/{name}")
	public boolean isProductAvailable(@PathVariable int prodId) {
		boolean isAvailable = productService.isProductAvailable(prodId);
		return isAvailable;
	}

}
