package com.ms.boot.Productms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ms.boot.Productms.model.Product;
import com.ms.boot.Productms.model.ProductDTO;
import com.ms.boot.Productms.service.ProductService;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@RequestMapping(path = "/v0/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getProduct(@PathVariable int id) {

		Product p = productService.getProduct(id);
		if (p == null) {
			ResponseEntity<Product> response = new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
			return response;
		} else {
			ResponseEntity<Product> response = new ResponseEntity<Product>(p, HttpStatus.FOUND);
			return response;

		}
	}

	@RequestMapping(path = "/v1/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductDTO> getProductv1(@PathVariable int id) {

		Product p = productService.getProduct(id);
		if (p == null) {

			ResponseEntity<ProductDTO> response = new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
			return response;
		} else {
			ProductDTO pDTO = productService.applyDiscount01(p);
			ResponseEntity<ProductDTO> response = new ResponseEntity<ProductDTO>(pDTO, HttpStatus.FOUND);
			return response;

		}
	}

	@RequestMapping(path = "/v2/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductDTO> getProductv2(@PathVariable int id) {

		Product p = productService.getProduct(id);
		if (p == null) {

			ResponseEntity<ProductDTO> response = new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
			return response;
		} else {
			ProductDTO pDTO = productService.applyDiscount02(p);
			ResponseEntity<ProductDTO> response = new ResponseEntity<ProductDTO>(pDTO, HttpStatus.FOUND);
			return response;

		}
	}

	@RequestMapping(path = "/v3/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductDTO> getProductv3(@PathVariable int id) {

		Product p = productService.getProduct(id);
		if (p == null) {

			ResponseEntity<ProductDTO> response = new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
			return response;
		} else {
			ProductDTO pDTO = productService.applyDiscount03(p);
			ResponseEntity<ProductDTO> response = new ResponseEntity<ProductDTO>(pDTO, HttpStatus.FOUND);
			return response;

		}
	}
	
	@RequestMapping(path = "/v4/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductDTO> getProductv4(@PathVariable int id) {

		Product p = productService.getProduct(id);
		if (p == null) {

			ResponseEntity<ProductDTO> response = new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
			return response;
		} else {
			ProductDTO pDTO = productService.applyDiscount04(p);
			ResponseEntity<ProductDTO> response = new ResponseEntity<ProductDTO>(pDTO, HttpStatus.FOUND);
			return response;

		}
	}
	
	@RequestMapping(path = "/v5/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProductDTO> getProductv5(@PathVariable int id) {

		Product p = productService.getProduct(id);
		if (p == null) {

			ResponseEntity<ProductDTO> response = new ResponseEntity<ProductDTO>(HttpStatus.NOT_FOUND);
			return response;
		} else {
			ProductDTO pDTO = productService.applyDiscount05(p);
			ResponseEntity<ProductDTO> response = new ResponseEntity<ProductDTO>(pDTO, HttpStatus.FOUND);
			return response;

		}
	}


}
