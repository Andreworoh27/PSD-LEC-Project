package food_ordering.context.transaction_context.events;

import view.TransactionHistoryPage;

public class GoToTransactionHistoryPageEvent {
	public static void run() {
		new TransactionHistoryPage();
	}
}
