package com.vending.machine.model;

public class Product {

	int id ;
	int  sparkValue;
	String name;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}
	public Product() {
		
	}
	public Product(int id, int sparkValue, String name) {
		super();
		this.id = id;
		this.sparkValue = sparkValue;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSparkValue() {
		return sparkValue;
	}
	public void setSparkValue(int sparkValue) {
		this.sparkValue = sparkValue;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
