package de.tha.prog2.task2;

import java.util.List;
import java.util.Map;

public interface WareHouse {

	public void addProduct(Product p, int menge);
	
	public Map<Product, Integer> getInventory();
	
	public int getStock(Product p);
	
	public List<Product> listAvailableProducts(String category);
}