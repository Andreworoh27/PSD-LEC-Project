package payment.context.payment_context.handler;

import payment.context.payment_context.model.entity.DanaPayment;
import payment.context.payment_context.model.entity.GopayPayment;
import payment.context.payment_context.model.entity.OVOPayment;
import payment.context.payment_context.repository.PaymentRepository;

public class PaymentHandler {
	public static DanaPayment createDanaPayment() {
		return PaymentRepository.createDanaPayment();
	}
	
	public static OVOPayment createOvoPayment() {
		return PaymentRepository.createOvoPayment();
	}
	
	public static GopayPayment createGopayPayment() {
		return PaymentRepository.createGopayPayment();
	}
}
