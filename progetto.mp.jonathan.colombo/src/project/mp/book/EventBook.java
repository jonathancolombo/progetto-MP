package project.mp.book;

public abstract class EventBook {
	
	private Book book;

	public EventBook (Book book) {
		this.book = book;
	}

	public Book getBook() {
		return book;
	}	

}
