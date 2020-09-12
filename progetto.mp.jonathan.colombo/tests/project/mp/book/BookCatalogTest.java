package project.mp.book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;

public class BookCatalogTest {

	private BookCatalog catalogBooksTest;
	private MockBook bookTest;
	private MockBook bookTest2;
	
	@Before
	public void setupBookCatalog() {
		catalogBooksTest = new BookCatalog();
		bookTest = new MockBook("Animals Factory", "George Orwell", true);
		bookTest2 = new MockBook("Dracula", "Bram Stoker", true);
	}

	@Test
	public void testAddBook() {
		assertTrue(catalogBooksTest.addBook(bookTest));
		
		assertThat(catalogBooksTest.getBooks())
        .containsExactly(bookTest);
	}
	
	@Test
	public void testRemoveBook() {
		assertTrue(catalogBooksTest.addBook(bookTest));
		assertTrue(catalogBooksTest.removeBook(bookTest));
		assertThat(catalogBooksTest.getBooks())
        .containsExactly();
	}
	
	@Test
	public void testContainsBook() {
		assertFalse(catalogBooksTest.containsBook(bookTest2));
	}
	
	@Test
	public void testAddBookException() {
		Book bookNull = null; 
		assertThatThrownBy(() -> catalogBooksTest.addBook(bookNull))
				.isInstanceOf(RuntimeException.class)
				.hasMessage("Parameter must not be null");
	}
	
	@Test 
	public void testRemoveContainsBookTrue() {
		assertTrue(catalogBooksTest.addBook(bookTest));
		assertTrue(catalogBooksTest.containsBook(bookTest));
		assertTrue(catalogBooksTest.removeBook(bookTest));
		assertEquals(0, catalogBooksTest.sizeBooks());
	}
	
	@Test
	public void testRemoveBookException() {
		Book bookNull = null; 
		assertThatThrownBy(() -> catalogBooksTest.removeBook(bookNull))
				.isInstanceOf(RuntimeException.class)
				.hasMessage("Parameter must not be null");
	}
	
	@Test
	public void testContainsBookException() {
		Book bookNull = null; 
		assertThatThrownBy(() -> catalogBooksTest.containsBook(bookNull))
				.isInstanceOf(RuntimeException.class)
				.hasMessage("Parameter must not be null");
	}
	
	@Test
	public void testVehiclesIterator() {
		assertTrue(catalogBooksTest.addBook(bookTest));
		assertTrue(catalogBooksTest.addBook(bookTest2));
		
		assertThat(catalogBooksTest.createBookIterator())
		.toIterable()
		.containsExactlyInAnyOrder(bookTest, bookTest2);
	}
	
	@Test
	public void testFindFirstBookSuccess() {
		assertTrue(catalogBooksTest.addBook(bookTest));
		assertTrue(catalogBooksTest.addBook(bookTest2));
		
		String nameTitle = "Animals Factory";
		
		assertEquals(bookTest, catalogBooksTest.findByTitle(nameTitle).get());
	}
	
	@Test
	public void testFindByTitleBookOptionalEmpty() {
		assertTrue(catalogBooksTest.addBook(bookTest));
		assertTrue(catalogBooksTest.addBook(bookTest2));
		
		String nameTitle = "C++ ProgrammingLanguage";
		
		assertEquals(Optional.empty(), catalogBooksTest.findByTitle(nameTitle));
	}
	
	@Test
	public void testFindByTitleBookParameterException() {
		String titleNull = null; 
		
		assertThatThrownBy(() -> catalogBooksTest.findByTitle(titleNull))
				.isInstanceOf(RuntimeException.class)
				.hasMessage("Parameter must not be null");
	}
	
}
