package com.ms.boot.InitialDemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ms.boot.InitialDemo.product.Product;
import com.ms.boot.InitialDemo.product.ProductJPARepository;

@SpringBootApplication
public class InitialDemoApplication {

	@Autowired
	ProductJPARepository repo;

	public static void main(String[] args) {
		SpringApplication.run(InitialDemoApplication.class, args);
	}

	@Bean
	CommandLineRunner inspect(ApplicationContext ctx) {
		return (r) -> {
			int beanCount = ctx.getBeanDefinitionCount();
			String[] beans = ctx.getBeanDefinitionNames();
			System.out.println("Bean Count = " + beanCount);
			for (int i = 0; i < beanCount; i++) {
				// System.out.println(beans[i]);
			}

			List<Product> products = new ArrayList<Product>();
			repo.save(new Product(100, "Lego 300", "Space Craft Lego", 900.76));
			repo.save(new Product(101, "Bass Guitar", "6 Strings", 800.00));
			repo.save(new Product(102, "Electric Kettle", "5 ltrs", 200.78));
			repo.save(new Product(103, "Solar Powered Robo", "8 hours battery life", 10000.00));
			repo.save(new Product(104, "MS Bootcamp", "MS bootcamp for all learning team", 21.00));
			/*
			 * products.stream().map((p) -> (repo.save(p))
			 * 
			 * 
			 * 
			 * );
			 */

			System.out.println("Saved " + products.size());

		};
	}

}
