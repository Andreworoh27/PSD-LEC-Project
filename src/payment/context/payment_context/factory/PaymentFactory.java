package payment.context.payment_context.factory;

import payment.context.payment_context.model.entity.DanaPayment;
import payment.context.payment_context.model.entity.GopayPayment;
import payment.context.payment_context.model.entity.OVOPayment;

public class PaymentFactory {
	public static GopayPayment createGopayPayment(String paymentID) {
		GopayPayment gp = new GopayPayment(paymentID);
		return gp;
	}
	
	public static OVOPayment createOvoPayment(String paymentID) {
		OVOPayment op = new OVOPayment(paymentID);
		return op;
	}
	
	public static DanaPayment createDanaPayment(String paymentID) {
		DanaPayment dp = new DanaPayment(paymentID);
		return dp;
	}
}
