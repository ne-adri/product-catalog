package com.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query(value="SELECT * FROM product WHERE NAME LIKE %:name%",nativeQuery = true)
	public List<Product> findProductsByName(@Param("name") String name);

}
