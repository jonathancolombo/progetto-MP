package project.mp.book;

public class PaymentCashier {

	private BookStrategy bookStrategy;

	public PaymentCashier(BookStrategy bookStrategy) {
		this.bookStrategy = bookStrategy;
	}

	public int totalPayment(int priceBook) {
		exceptionArgument(priceBook);

		return bookStrategy.calculatePayment(priceBook);
	}
	
	private void exceptionArgument(int parameterPayment) {
		if(parameterPayment <= 0)
			throw new IllegalArgumentException("Argument must not be equals/less than zero");
	}
	
}
