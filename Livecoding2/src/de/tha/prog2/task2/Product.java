package de.tha.prog2.task2;

public interface Product extends Comparable<Product> {
	
	public String getCategory();
	public double getPrice();
	public String getName();

}