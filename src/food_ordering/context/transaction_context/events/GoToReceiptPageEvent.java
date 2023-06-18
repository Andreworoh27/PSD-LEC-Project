package food_ordering.context.transaction_context.events;

import food_ordering.context.transaction_context.models.TransactionHeader;
import view.ReceiptPage;

public class GoToReceiptPageEvent {
	public static void run(String transactionId) {
		TransactionHeader header = OnSelectTransactionHeader.getHeaderById(transactionId);
		if(header != null) {
			new ReceiptPage(header);
		}else {
			System.out.println("error");
		}
		
	}
}
