package payment.context.payment_context.model.entity;

import catalogue.context.food_context.models.value_object.Price;
import payment.api_connector.DanaConnector;

public class DanaPayment extends PaymentAbstract {
	
	
	/**
	 * @param paymentID
	 */
	public DanaPayment(String paymentID) {
		super(paymentID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() {
		this.paymentID = DanaConnector.getInstance().getPaymentID();
	}

	@Override
	public void pay(Price totalPrice) {
		DanaConnector.getInstance().pay();
		System.out.println("Thank you for paying with Dana");
		System.out.println("Payment ID: " + this.paymentID);
		System.out.println("Total Payment: " + totalPrice.getValue());
	}


}
