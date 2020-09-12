package project.mp.book;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MockBookTest {

	private MockBook mockBookTest;
	
	@Before
	public void setupMockBookTest() {
		mockBookTest = new MockBook("Animal Factory", "George Orwell", true);
	}
	
	@Test
	public void testAddRemoveObserversMockBook() {
		BookObserver observer = new BookObserver() {
			
			@Override
			public void update(EventBook event) {
				
			}
		};
	
		mockBookTest.attachObserver(observer);
	 	assertTrue(mockBookTest.getObservers().contains(observer));
	 
	 
	 	mockBookTest.detachObserver(observer);
	 	assertTrue(mockBookTest.getObservers().isEmpty());
	}
	
	@Test
	public void testSetChangedMockBookAvailable() {
		UserObserver observer = new UserObserver();
		mockBookTest.attachObserver(observer);
		mockBookTest.setChangedBookAvailable(false);
	 
		EventBookAvailable event = (EventBookAvailable) observer.getEvent();
		assertEquals(mockBookTest, event.getBook());
		assertFalse(mockBookTest.isAvailable());
		assertTrue(event.isBookAvailable());
	}

}
