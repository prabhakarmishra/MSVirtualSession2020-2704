package com.ms.boot.Productms.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "producttag")
@IdClass(ProductTagID.class)
public class ProductTag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	@Id
	private String tag;

	public ProductTag(int id, String tag) {
		super();
		this.id = id;
		this.tag = tag;
	}

	public ProductTag() {
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

}
