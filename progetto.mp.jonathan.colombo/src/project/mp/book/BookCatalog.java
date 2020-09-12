package project.mp.book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;

public class BookCatalog {

	private Collection<Book> books = new ArrayList<>();
	
	public Iterator<Book> createBookIterator(){
		return books.iterator();
	}
	
	public boolean addBook(Book book) {
		exceptionParameter(book);

		return books.add(book);
	}

	public boolean removeBook(Book book) {
		exceptionParameter(book);
		
		return books.remove(book);
	}
	
	public int sizeBooks() {
		return books.size();
	}
	
	public boolean containsBook(Book book) {
		exceptionParameter(book);
		
		return books.contains(book);
	}
	
	/**
	 * just for testing
	 */
	Collection<Book> getBooks() {
		return books;
	}

	public Optional<Book> findByTitle(String nameTitle) {
		exceptionParameter(nameTitle);

		return books.stream()
				.filter(book -> book.getTitle().equals(nameTitle))
	            .findFirst();
	}
	 
	private <T> void exceptionParameter(T parameter) {
		Objects.requireNonNull(parameter, "Parameter must not be null");
	}
	
}
