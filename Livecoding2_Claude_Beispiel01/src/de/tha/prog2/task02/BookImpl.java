package de.tha.prog2.task02;

import java.util.Objects;

public class BookImpl implements Book {
	
	private String isbn;
	private String title;
	private String genre;
	private double rating;
	
	@Override
	public int hashCode() {
		return Objects.hash(isbn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof BookImpl other) {
			return Objects.equals(isbn, other.isbn);
		} else {
			return false;
		}
	}

	public BookImpl(String isbn, String title, double rating, String genre) {
		this.isbn = isbn;
		this.title = title;
		this.genre = genre;
		this.rating = rating;
	}

	@Override
	public int compareTo(Book o) {
		return Double.compare(this.rating, o.getRating());
	}

	@Override
	public String getIsbn() {
		return this.isbn;
	}

	@Override
	public String getTitle() {
		return this.title;
	}

	@Override
	public String getGenre() {
		return this.genre;
	}

	@Override
	public double getRating() {
		return this.rating;
	}

	@Override
	public String toString() {
		return "BookImpl [isbn=" + isbn + ", title=" + title + ", genre=" + genre + ", rating=" + rating + "]";
	}
		
}
