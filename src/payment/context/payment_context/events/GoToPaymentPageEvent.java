package payment.context.payment_context.events;

import catalogue.context.food_context.models.value_object.Price;
import view.PaymentPage;

public class GoToPaymentPageEvent {
	public static void run(Price totalPrice, String transactionId) {
		new PaymentPage(totalPrice, transactionId);
	}
}
