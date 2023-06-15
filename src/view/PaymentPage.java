package view;

import payment.context.payment_context.events.OnPaymentSelectedEvent;
import utility.UtilityPage;

public class PaymentPage {
	public PaymentPage() {
		viewDisplay();
		int opt = UtilityPage.getOption(1, 3);
		OnPaymentSelectedEvent.run(opt);
		//TODO: Redirect to ReceiptPage 
	}
	
	public void viewDisplay() {
		System.out.println("Please select payment:");
		System.out.println("1. Dana");
		System.out.println("2. Gopay");
		System.out.println("3. OVO");
	}
}
