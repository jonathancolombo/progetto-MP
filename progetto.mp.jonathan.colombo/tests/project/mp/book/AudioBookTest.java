package project.mp.book;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AudioBookTest {

	private AudioBook audioBookTest;
	
	@Before
	public void setupAudioBookTest() {
		audioBookTest = new AudioBook("Java for Impatient", "Cay Horstmann", true,
				"Pearson Reader");
	}
	
	@Test
	public void testAudioBookAddRemoveObserver() {
		BookObserver bookObserver = new BookObserver() {
			
			@Override
			public void update(EventBook event) {
				
			}
		};
		
		 audioBookTest.attachObserver(bookObserver);
		 assertTrue(audioBookTest.getObservers().contains(bookObserver));
		 
		 
		 audioBookTest.detachObserver(bookObserver);
		 assertTrue(audioBookTest.getObservers().isEmpty());
	}
	
	@Test
	public void testChangeAudioBookAvailable() {
		audioBookTest.setChangedBookAvailable(false);
		assertFalse(audioBookTest.isAvailable());
	}

	@Test
	public void testSetChangedVehicleAvailable() {
		UserObserver bookObserver = new UserObserver();
		audioBookTest.attachObserver(bookObserver);
		audioBookTest.setChangedBookAvailable(false);
	 
		EventBookAvailable event = (EventBookAvailable) bookObserver.getEvent();
		assertEquals(audioBookTest, event.getBook());
		assertFalse(audioBookTest.isAvailable());
		assertTrue(event.isBookAvailable());
	}
	
}
