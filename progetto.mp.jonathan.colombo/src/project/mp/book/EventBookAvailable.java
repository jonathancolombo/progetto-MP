package project.mp.book;

public class EventBookAvailable extends EventBook {

	private boolean bookAvailable;

	public EventBookAvailable(Book book, boolean bookAvailable) {
		super(book);
		this.bookAvailable = bookAvailable;
	}

	public boolean isBookAvailable() {
		return bookAvailable;
	}

}
