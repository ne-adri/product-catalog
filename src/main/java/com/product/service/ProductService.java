package com.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.entity.Product;
import com.product.exceptions.QuantityUnsatisfiedException;
import com.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll(){
		List<Product> allProds = repo.findAll();
		return allProds;
	}
	public Product getProduct(int id) {
		return repo.findById(id).get();
	}
	public List<Product> getProductsByName(String name){
		System.out.println("Getting product like :"+ name );
		List<Product> prods = repo.findProductsByName(name);
		return prods;
	}
	public void addProduct(Product product) {
		repo.save(product);
	}

	public Product updateProduct(Product product, int id) {
		Product prod = repo.getById(id);
		prod.setName(product.getName());
		prod.setDescription(product.getDescription());
		prod.setPrice(product.getPrice());
		prod.setQuantity(product.getQuantity());
		prod.setCategory(product.getCategory());
//		prod.setTags(product.getTags());
		return repo.save(prod);
	}
	public String deleteProduct(int id) {
		String resp= "";
		Product prod = repo.findById(id).orElse(null);
		if(prod==null){
			resp = "No product found with id : "+id;
		}
		else {
			repo.deleteById(id);
			resp = "Product successfully deleted having id : "+id;
		}
		return resp;
	}
	public Product manageQuantity(int id, int updatedQuantity) {
		Product resp = new Product();
		Product prod = repo.findById(id).orElse(null);
		if(prod!= null) {
			int quantity = prod.getQuantity();
			if(quantity<=0) {
				throw new QuantityUnsatisfiedException(quantity);
			}
			else {
				System.out.println("Updating Quantity from "+quantity+ " to "+updatedQuantity);
				prod.setQuantity(updatedQuantity);
				resp = repo.save(prod);
			}
		}
		System.out.println("Updated Quantity = "+resp.getQuantity());
		return resp;
	}
	
	public boolean isProductAvailable(int prodId) {
		Product p = getProduct(prodId);
		if(p!=null) return true;
		return false;
	}
}
