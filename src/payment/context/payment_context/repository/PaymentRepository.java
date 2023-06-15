package payment.context.payment_context.repository;

import payment.api_connector.DanaConnector;
import payment.api_connector.GopayConnector;
import payment.api_connector.OVOConnector;
import payment.context.payment_context.factory.PaymentFactory;
import payment.context.payment_context.model.entity.DanaPayment;
import payment.context.payment_context.model.entity.GopayPayment;
import payment.context.payment_context.model.entity.OVOPayment;

public class PaymentRepository {
	private static GopayConnector gc = GopayConnector.getInstance();
	private static DanaConnector dc = DanaConnector.getInstance();
	private static OVOConnector oc = OVOConnector.getInstance();
	
	public static DanaPayment createDanaPayment() {
		return PaymentFactory.createDanaPayment(dc.getPaymentID());
	}
	
	public static OVOPayment createOvoPayment() {
		return PaymentFactory.createOvoPayment(oc.getPaymentID());
	}
	
	public static GopayPayment createGopayPayment() {
		return PaymentFactory.createGopayPayment(gc.getPaymentID());
	}
}
