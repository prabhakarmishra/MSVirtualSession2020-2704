package com.ms.boot.Discountms;

public class DiscountResponse {
	private ProductCategory category;
	private double mrp;
	private double drp;
	private double fixedCategoryDiscount;
	private double onSpotDiscount;
	
	
	
	public DiscountResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "DiscountResponse [category=" + category + ", mrp=" + mrp + ", drp=" + drp + ", fixedCategoryDiscount="
				+ fixedCategoryDiscount + ", onSpotDiscount=" + onSpotDiscount + "]";
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

	public DiscountResponse(ProductCategory category, double mrp, double drp, double fixedCategoryDiscount,
			double onSpotDiscount) {
		super();
		this.category = category;
		this.mrp = mrp;
		this.drp = drp;
		this.fixedCategoryDiscount = fixedCategoryDiscount;
		this.onSpotDiscount = onSpotDiscount;
	}

	

}
