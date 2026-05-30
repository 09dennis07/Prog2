package de.tha.prog2.task02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LibraryCatalogImpl implements LibraryCatalog, Iterable<Book>{
	
	protected Map<Book, Integer> inventory;
	
	public LibraryCatalogImpl() {
		this.inventory = new HashMap<>();
	}

	@Override
	public void addBook(Book book, int quantity) {
		if (quantity > 0) {
			inventory.merge(book, quantity, Integer::sum);			
		}
	}

	@Override
	public Map<Book, Integer> getInventory() {
		return new HashMap<>(inventory);
	}

	@Override
	public int getStock(Book book) {
		if (inventory.containsKey(book)) {
			return inventory.get(book);
		} else {
			return 0;
		}
	}

	@Override
	public List<Book> listAvailableBooks(String genre) {
		List <Book> bookList = new ArrayList<Book>();
		for (Map.Entry<Book, Integer> entry : inventory.entrySet()) {
			Book currentBook = entry.getKey();
			int bookQuant = entry.getValue();
			
			if (currentBook.getGenre().equals(genre) && bookQuant > 0) {
				bookList.add(currentBook);
			}
		}
		bookList.sort(Collections.reverseOrder());
		return bookList;
	}

	@Override
	public Iterator<Book> iterator() {
		List<Book> sortedBooks = new ArrayList<>(inventory.keySet());
		Collections.sort(sortedBooks);
		return sortedBooks.iterator();
	}

}
