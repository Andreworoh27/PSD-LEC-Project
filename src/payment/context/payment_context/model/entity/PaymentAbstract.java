package payment.context.payment_context.model.entity;

import catalogue.context.food_context.models.value_object.Price;

public abstract class PaymentAbstract {
	String paymentID;
	
	/**
	 * @param paymentID
	 */
	public PaymentAbstract(String paymentID) {
		super();
		this.paymentID = paymentID;
	}
	
	public String getPaymentID() {
		return paymentID;
	}

	public void setPaymentID(String paymentID) {
		this.paymentID = paymentID;
	}

	public abstract void connect();
	public abstract void pay(Price totalPrice);	
}
