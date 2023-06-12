package payment.context.payment_context.model.entity;

import catalogue.context.food_context.models.value_object.Price;

public class GopayPayment extends PaymentAbstract {
	

	public GopayPayment(String paymentID) {
		super(paymentID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() {
		System.out.println("Connecting to Gopay Server...");
	}

	@Override
	public void pay(Price totalPrice) {
		System.out.println("Total Payment: " + totalPrice.getValue());

	}

}
