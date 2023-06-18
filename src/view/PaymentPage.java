package view;

import catalogue.context.food_context.models.value_object.Price;
import food_ordering.context.transaction_context.events.GoToReceiptPageEvent;
import payment.context.payment_context.events.OnPaymentSelectedEvent;
import payment.context.payment_context.model.entity.PaymentAbstract;
import utility.UtilityPage;

public class PaymentPage {
	public PaymentPage(Price totalPrice, String transactionId) {
		UtilityPage.changePage();
		viewDisplay();
		int opt = UtilityPage.getOption(1, 3);
		PaymentAbstract payment = OnPaymentSelectedEvent.run(opt);
		payment.pay(totalPrice);
		UtilityPage.enterToContinue();
		GoToReceiptPageEvent.run(transactionId); 
	}
	
	public void viewDisplay() {
		System.out.println("Please select payment:");
		System.out.println("1. Dana");
		System.out.println("2. Gopay");
		System.out.println("3. OVO");
	}
}
