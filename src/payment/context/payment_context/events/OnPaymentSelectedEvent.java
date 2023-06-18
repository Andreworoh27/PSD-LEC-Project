package payment.context.payment_context.events;

import payment.context.payment_context.controller.PaymentController;
import payment.context.payment_context.model.entity.PaymentAbstract;

public class OnPaymentSelectedEvent {
	public static PaymentAbstract run(int paymentOption) {
		//TODO: return payment to TrHeader.Payment
		return PaymentController.makePayment(paymentOption);
	}
}
