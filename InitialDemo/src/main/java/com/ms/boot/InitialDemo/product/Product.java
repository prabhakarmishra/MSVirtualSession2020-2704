package com.ms.boot.InitialDemo.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "product")
public class Product {

	/*
	 * @Autowired
	 * 
	 * @Transient private ProductRepository repo;
	 */

	@Id
	// @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	@Column(name = "shortdescription", table = "product")
	private String shortDescription;

	private double mrp;

	public Product(Integer id, String name, String shortDescription, double mrp) {
		super();
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
		this.mrp = mrp;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

}
