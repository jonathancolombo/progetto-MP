package project.mp.book;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NovelTest {

	private Novel novelTest;
	
	@Before
	public void setupAudioBookTest() {
		novelTest = new Novel("Promessi Sposi", "Alessandro Manzoni", true,
				"Letteratura");
	}
	
	@Test
	public void testAudioBookAddRemoveObserver() {
		BookObserver bookObserver = new BookObserver() {
			
			@Override
			public void update(EventBook event) {
				
			}
		};
		
		 novelTest.attachObserver(bookObserver);
		 assertTrue(novelTest.getObservers().contains(bookObserver));
		 
		 
		 novelTest.detachObserver(bookObserver);
		 assertTrue(novelTest.getObservers().isEmpty());
	}
	
	@Test
	public void testChangeNovelAvailable() {
		novelTest.setChangedBookAvailable(false);
		assertFalse(novelTest.isAvailable());
	}

	@Test
	public void testSetChangedNovelAvailable() {
		UserObserver bookObserver = new UserObserver();
		novelTest.attachObserver(bookObserver);
		novelTest.setChangedBookAvailable(false);
	 
		EventBookAvailable event = (EventBookAvailable) bookObserver.getEvent();
		assertEquals(novelTest, event.getBook());
		assertFalse(novelTest.isAvailable());
		assertTrue(event.isBookAvailable());
	}
	
}
