package view;

import java.util.ArrayList;
import java.util.Scanner;

import food_ordering.context.transaction_context.events.OnSelectTransactionDetail;
import food_ordering.context.transaction_context.events.OnSelectTransactionHeader;
import food_ordering.context.transaction_context.models.entity.TransactionDetail;
import food_ordering.context.transaction_context.models.entity.TransactionHeader;
import utility.UtilityPage;

public class TransactionHistoryPage {
	Scanner scan = new Scanner(System.in);
	public TransactionHistoryPage() {
		UtilityPage.changePage();
		historyDisplay();
		UtilityPage.enterToContinue();
	}
	
	public void historyDisplay() {
		ArrayList<TransactionHeader> headers = OnSelectTransactionHeader.getAllTransactionHeaders();
		if(headers.size()!=0) {
			for(TransactionHeader h : headers) {
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
		}else {
			System.out.println("There are no transaction history yet");
		}
	}
	
}
