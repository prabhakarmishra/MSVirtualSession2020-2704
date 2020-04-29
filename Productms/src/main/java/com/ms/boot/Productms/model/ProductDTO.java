package com.ms.boot.Productms.model;

import java.util.ArrayList;
import java.util.List;

public class ProductDTO {

	
	private int id;
	private String name;
	private String shortDescription;
	private ProductCategory category;
	private double mrp;
	private double drp;
	private double fixedCategoryDiscount;
	private double onSpotDiscount;
	
	
	private List<ProductTag> tags = new ArrayList<ProductTag>();
	
	
	
	public ProductDTO(int id, String name, String shortDescription, ProductCategory category, double mrp, double drp,
			double fixedCategoryDiscount, double onSpotDiscount, List<ProductTag> tags) {
		super();
		this.id = id;
		this.name = name;
		this.shortDescription = shortDescription;
		this.category = category;
		this.mrp = mrp;
		this.drp = drp;
		this.fixedCategoryDiscount = fixedCategoryDiscount;
		this.onSpotDiscount = onSpotDiscount;
		this.tags = tags;
	}


	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public ProductCategory getCategory() {
		return category;
	}
	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	public double getMrp() {
		return mrp;
	}
	public void setMrp(double mrp) {
		this.mrp = mrp;
	}
	public List<ProductTag> getTags() {
		return tags;
	}
	public void setTags(List<ProductTag> tags) {
		this.tags = tags;
	}
	public double getDrp() {
		return drp;
	}
	public void setDrp(double drp) {
		this.drp = drp;
	}
	
	
	public double getFixedCategoryDiscount() {
		return fixedCategoryDiscount;
	}


	public void setFixedCategoryDiscount(double fixedCategoryDiscount) {
		this.fixedCategoryDiscount = fixedCategoryDiscount;
	}


	public double getOnSpotDiscount() {
		return onSpotDiscount;
	}


	public void setOnSpotDiscount(double onSpotDiscount) {
		this.onSpotDiscount = onSpotDiscount;
	}


	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", name=" + name + ", shortDescription=" + shortDescription + ", category="
				+ category + ", mrp=" + mrp + ", drp=" + drp + ", fixedCategoryDiscount=" + fixedCategoryDiscount
				+ ", onSpotDiscount=" + onSpotDiscount + ", tags=" + tags + "]";
	}
	

}
