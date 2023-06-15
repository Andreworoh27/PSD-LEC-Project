package payment.context.payment_context.events;

import view.PaymentPage;

public class GoToPaymentPageEvent {
	public static void run() {
		new PaymentPage();
	}
}
