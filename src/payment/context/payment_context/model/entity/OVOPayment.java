package payment.context.payment_context.model.entity;

import catalogue.context.food_context.models.value_object.Price;
import payment.api_connector.OVOConnector;

public class OVOPayment extends PaymentAbstract {
	
	
	/**
	 * @param paymentID
	 */
	public OVOPayment(String paymentID) {
		super(paymentID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void connect() {
		this.paymentID = OVOConnector.getInstance().getPaymentID();
	}

	@Override
	public void pay(Price totalPrice) {
		OVOConnector.getInstance().pay();
		System.out.println("Thank you for paying with OVO");
		System.out.println("Payment ID: " + this.paymentID);
		System.out.println("Total Payment: " + totalPrice.getValue());
		
	}


}
