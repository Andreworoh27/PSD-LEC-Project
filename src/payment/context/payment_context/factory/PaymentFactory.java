package payment.context.payment_context.factory;

import payment.context.payment_context.model.entity.DanaPayment;
import payment.context.payment_context.model.entity.GopayPayment;
import payment.context.payment_context.model.entity.OVOPayment;

public class PaymentFactory {
	public static GopayPayment createGopayPayment(String paymentId) {
		GopayPayment gp = new GopayPayment(paymentId);
		return gp;
	}
	
	public static OVOPayment createOvoPayment(String paymentId) {
		OVOPayment op = new OVOPayment(paymentId);
		return op;
	}
	
	public static DanaPayment createDanaPayment(String paymentId) {
		DanaPayment dp = new DanaPayment(paymentId);
		return dp;
	}
}
