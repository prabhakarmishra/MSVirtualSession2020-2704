package com.ms.boot.Productms.model;

import java.io.Serializable;

public class ProductTagID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String tag;

	public ProductTagID(int id, String tag) {
		super();
		this.id = id;
		this.tag = tag;
	}

	public ProductTagID() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
