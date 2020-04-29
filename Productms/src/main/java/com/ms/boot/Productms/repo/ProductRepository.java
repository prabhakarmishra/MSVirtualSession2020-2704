package com.ms.boot.Productms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.ms.boot.Productms.model.Product;

@Component
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
