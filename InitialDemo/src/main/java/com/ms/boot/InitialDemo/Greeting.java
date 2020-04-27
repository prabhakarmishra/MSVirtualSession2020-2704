package com.ms.boot.InitialDemo;

import java.util.Date;

public class Greeting {
	
	private String text;
	private String salutation;
	private Date date;
	
	
	
	public Greeting() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Greeting(String text, String salutation, Date date) {
		super();
		this.text = text;
		this.salutation = salutation;
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
