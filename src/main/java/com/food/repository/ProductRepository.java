package com.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.food.entity.Product;

public interface ProductRepository  extends JpaRepository<Product, Integer>{
	
	

}
