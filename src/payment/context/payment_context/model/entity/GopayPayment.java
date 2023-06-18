package payment.context.payment_context.model.entity;

import catalogue.context.food_context.models.value_object.Price;
import payment.api_connector.GopayConnector;

public class GopayPayment extends PaymentAbstract {

	
	/**
	 * @param paymentID
	 */
	public GopayPayment(String paymentID) {
		super(paymentID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() {
		this.paymentID = GopayConnector.getInstance().getPaymentID();
	}

	@Override
	public void pay(Price totalPrice) {
		GopayConnector.getInstance().pay();
		System.out.println("Thank you for paying with Gopay");
		System.out.println("Payment ID: " + this.paymentID);
		System.out.println("Total Payment: " + totalPrice.getValue());

	}

}
