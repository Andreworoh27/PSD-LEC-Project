package payment.context.payment_context.model.entity;

import catalogue.context.food_context.models.value_object.Price;

public class OVOPayment extends PaymentAbstract {
	public OVOPayment(String paymentID) {
		super(paymentID);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void connect() {
		System.out.println("Connecting to OVO Server...");

	}

	@Override
	public void pay(Price totalPrice) {
		System.out.println("Total Payment: " + totalPrice.getValue());
		
	}


}
