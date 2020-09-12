package project.mp.book;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public abstract class Book {

	private String title;
	private String author;
	private boolean available;
	
	private Collection<BookObserver> observers = new ArrayList<>();
	
	public Book (String title, String author, boolean available) {
		this.title = title;
		this.author = author;
		this.available = available;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
	
	public boolean isAvailable() {
		return available;
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, available, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && available == other.available
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + 
				" [title=" + title + ", author=" + author + ", available=" + available + "]";
	}
	
	/**
	 * just for testing
	 */
	Collection<BookObserver> getObservers() {
		return observers;
	}

	public boolean attachObserver(BookObserver bookObserver) {
		return observers.add(bookObserver);
	}

	public boolean detachObserver(BookObserver bookObserver) {
		return observers.remove(bookObserver);
	}
	
	protected void setChangedBookAvailable(boolean newAvailableBook) {
		EventBook event = new EventBookAvailable(this, isAvailable());
		this.available = newAvailableBook;
		notifyObservers(event);
	}
	
	protected void notifyObservers(EventBook event) {
		observers.stream().forEach(observer -> observer.update(event));
	}
	
}
