package payment.context.payment_context.model.entity;

import catalogue.context.food_context.models.value_object.Price;

public class DanaPayment extends PaymentAbstract {

	public DanaPayment(String paymentID) {
		super(paymentID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() {
		System.out.println("Connecting to Dana Server...");

	}

	@Override
	public void pay(Price totalPrice) {
		System.out.println("Total Payment: " + totalPrice.getValue());
	}


}
