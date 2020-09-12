package project.mp.book;

public class CreditCardBookStrategy implements BookStrategy {
	
	private int percental;

	public CreditCardBookStrategy(int percentalRental) {
		this.percental = percentalRental;
	}

	@Override
	public int calculatePayment(int priceBook) {
		exceptionArgument(priceBook);
		
		return priceBook - (priceBook * percental / 100);
	}

	private void exceptionArgument(int parameterPayment) {
		if(parameterPayment <= 0)
			throw new IllegalArgumentException("Argument must not be equals/less than zero");
	}

}
