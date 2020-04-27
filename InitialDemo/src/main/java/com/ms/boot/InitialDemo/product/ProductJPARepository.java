package com.ms.boot.InitialDemo.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductJPARepository extends JpaRepository<Product, Integer> {


}
