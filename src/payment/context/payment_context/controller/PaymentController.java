package payment.context.payment_context.controller;

import payment.context.payment_context.handler.PaymentHandler;
import payment.context.payment_context.model.entity.PaymentAbstract;

public class PaymentController {
	public static PaymentAbstract makePayment(int option) {
		if(option == 1) {
			return PaymentHandler.createDanaPayment();
		}else if (option == 2) {
			return PaymentHandler.createGopayPayment();
		}else if (option == 3) {
			return PaymentHandler.createOvoPayment();
		}
		return null;
	}
}
