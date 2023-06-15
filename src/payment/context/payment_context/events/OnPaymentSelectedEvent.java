package payment.context.payment_context.events;

import payment.context.payment_context.controller.PaymentController;

public class OnPaymentSelectedEvent {
	public static void run(int paymentOption) {
		//TODO: return payment to TrHeader.Payment
		PaymentController.makePayment(paymentOption);
		
	}
}
