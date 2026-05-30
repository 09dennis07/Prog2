package de.tha.prog2.task2;

import java.util.Objects;

public class ProductImpl implements Product {
	
	private String name;
	private String category;
	private double price;
	
	public ProductImpl(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	@Override
	public int compareTo(Product o) {
		return Double.compare(this.getPrice(), o.getPrice());
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj instanceof ProductImpl other) {
			return Objects.equals(category, other.category) && 
			       Objects.equals(name, other.name) &&
			       Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "Produktname: " + name + ", Produktkategorie: " + category + ", Preis: " + price + "\n";
	}

	@Override
	public String getCategory() {
		return this.category;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public String getName() {
		return this.name;
	}
}