package project.mp.book;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PaymentCashierTest {

	private PaymentCashier cashierTest;
	
	@Before
	public void setupCashierTest() {
		cashierTest = new PaymentCashier(new BookStrategy() {
			
			@Override
			public int calculatePayment(int priceBook) throws IllegalArgumentException {
				return priceBook;
			}
		});
	}
	
	@Test
	public void testTotalPaymentDefault() {
		assertEquals(10, cashierTest.totalPayment(10));
	}
	
	@Test
	public void testTotalPaymentDefaultException() throws IllegalArgumentException {
		assertThatThrownBy(() -> cashierTest
				.totalPayment(0))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("Argument must not be equals/less than zero");			
	}

}
