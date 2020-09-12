package project.mp.book;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CrediCardBookStrategy {

	private CreditCardBookStrategy discountCreditCardTest;
	
	@Before
	public void setupRentalDiscountBookStrategy() {
		discountCreditCardTest = new CreditCardBookStrategy(20);
	}
	
	@Test
	public void testCalculateTotalPayment() {
		assertEquals(24, discountCreditCardTest.calculatePayment(30));
	}
	
	@Test
	public void testCalculateTotalPaymentException() throws IllegalArgumentException {
		assertThatThrownBy(() -> discountCreditCardTest
				.calculatePayment(0))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Argument must not be equals/less than zero");			
	}

}
