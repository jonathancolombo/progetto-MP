package project.mp.book;

public class CashBookStrategy implements BookStrategy {
	
	private int discountBook;
	private int taxBook;
	private int commissionCash;

	public CashBookStrategy(int discountBook, int taxBook, int commissionCash) {
		this.discountBook = discountBook;
		this.taxBook = taxBook;
		this.commissionCash = commissionCash;
	}

	@Override
	public int calculatePayment(int priceBook) {
		exceptionArgument(priceBook);

		return priceBook + taxBook + commissionCash - discountBook ;
	}

	private void exceptionArgument(int parameterPayment) {
		if(parameterPayment <= 0)
			throw new IllegalArgumentException("Argument must not be equals/less than zero");
	}

}
