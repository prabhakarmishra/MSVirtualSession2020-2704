package com.ms.boot.InitialDemo.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	private ProductJPARepository repo;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Product getProduct(@PathVariable Integer id) {
		Optional<Product> oProduct = repo.findById(id);	
		
		if(oProduct.isPresent())
		{
			return oProduct.get();
		}
		return null;
	}

}
