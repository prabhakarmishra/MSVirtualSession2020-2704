package com.ms.boot.Productms.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	private ProductCategory category;
	private double mrp;
	@OneToMany(targetEntity = ProductTag.class, mappedBy = "id", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @JoinColumn(name = "id")
	private List<ProductTag> tags = new ArrayList<ProductTag>();

	/*
	 * public void saveProduct() { repo.save(this); }
	 */
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int id, String name, String shortDescription, ProductCategory category, double mrp) {
		super();
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
		this.category = category;
		this.mrp = mrp;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ProductTag> getTags() {
		return tags;
	}

	public void setTags(List<ProductTag> tags) {
		this.tags = tags;
	}
}
