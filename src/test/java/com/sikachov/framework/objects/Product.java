package com.sikachov.framework.objects;


public class Product {

	private String name;
	private String href;
	private String description;
	private Double price;

	public Product(String name, String href2, Double price, String description) {
		this.setName(name);
		this.setPrice(price);
		this.setDescription(description);
		this.setHref(href2);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o){
		if(!this.getName().equals(((Product)o).getName())){
		return false;
		}else if(!this.getPrice().equals(((Product)o).getPrice())){
			return false;
		}else if(!this.getDescription().equals(((Product)o).getDescription())){
			return false;
		}else if(!this.getHref().equals(((Product)o).getHref())){
			return false;
		}
		return true;
	}

	

}
