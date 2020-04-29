package com.ms.boot.Discountms;

public class DiscountRequest {
	private ProductCategory category;
	private double mrp;
	
	
	public DiscountRequest(ProductCategory category, double mrp) {
		super();
		this.category = category;
		this.mrp = mrp;
	}
	public DiscountRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "DiscountRequest [category=" + category + ", mrp=" + mrp + "]";
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
	
	

}
