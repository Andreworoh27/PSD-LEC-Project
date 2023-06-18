package view;

import food_ordering.context.transaction_context.events.OnSelectTransactionDetail;
import food_ordering.context.transaction_context.models.TransactionDetail;
import food_ordering.context.transaction_context.models.TransactionHeader;
import utility.UtilityPage;

public class ReceiptPage {
	public ReceiptPage(TransactionHeader header) {
		UtilityPage.changePage();
		System.out.println("Order receipt");
		System.out.println("-------------");
		display(header);
		UtilityPage.enterToContinue();
	}
	
	public void display(TransactionHeader h) {
		System.out.println("TransactionID		: " + h.getTransactionID());
		System.out.println("Transaction Date	: " + h.getStringTransactionDateFormat());
		System.out.println("Pickup Date		: " + h.getStringPickupDateFormat());
		for(TransactionDetail d : OnSelectTransactionDetail.getDetailTransaction(h.getTransactionID())) {
			System.out.println("----------------------------------------------------------");
			System.out.println("	Food Name			: " + d.getFood().getFoodName());
			System.out.println("	Food Price			: " + d.getFood().getFoodPrice().getCurrency() + " " + d.getFood().getFoodPrice().getValue());
			System.out.println("	Quantity			: " + d.getQuantity());
			System.out.println("	Notes				: " + d.getNotes());
		}
		System.out.println("==============================================================");
	}
}
