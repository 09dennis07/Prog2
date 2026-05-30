package de.tha.prog2.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WareHouseImpl implements WareHouse, Iterable<Product> {

	protected Map<Product, Integer> inventory;

	public WareHouseImpl() {
		this.inventory = new HashMap<>();
	}

	@Override
	public Iterator<Product> iterator() {
		List<Product> sortedProducts = new ArrayList<>(inventory.keySet());
		Collections.sort(sortedProducts);
		return sortedProducts.iterator();
	}

	@Override
	public void addProduct(Product p, int quantity) {
		if (quantity > 0) {
			inventory.merge(p, quantity, Integer::sum);
		}
	}

	@Override
	public Map<Product, Integer> getInventory() {
		return new HashMap<>(inventory);
	}

	@Override
	public int getStock(Product p) {
		return inventory.getOrDefault(p, 0);
	}

	@Override
	public List<Product> listAvailableProducts(String category) {
		List<Product> productList = new ArrayList<>();
		for (Map.Entry<Product, Integer> entry : inventory.entrySet()) {
			Product currentProduct = entry.getKey();
			int currentStock = entry.getValue();

			if (currentProduct.getCategory().equals(category) && currentStock > 0) {
				productList.add(currentProduct);
			}
		}
		return productList;
	}
}