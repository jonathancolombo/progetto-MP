package project.mp.book;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CashBookStrategyTest {

	private CashBookStrategy discountTaxBookTest; 
	
	@Before
	public void setupDiscountTaxBookStrategy() {
		discountTaxBookTest = new CashBookStrategy(10, 3, 1);
	}

	@Test
	public void testCalculateTotalPayment() {
		assertEquals(19, discountTaxBookTest.calculatePayment(25));
	}
	
	@Test
	public void testCalculateTotalPaymentException() throws IllegalArgumentException {
		assertThatThrownBy(() -> discountTaxBookTest
				.calculatePayment(0))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Argument must not be equals/less than zero");			
	}
	
}
