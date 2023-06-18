package view;

import authentication.context.authentication_context.events.LogoutEvent;
import authentication.context.authentication_context.events.OnStartEvent;
import authentication.context.authentication_context.models.entity.User;
import catalogue.context.shop_context.events.GoToShopCatalogueEvent;
import food_ordering.context.cart_context.events.GoToCartEvent;
import food_ordering.context.transaction_context.events.GoToTransactionHistoryPageEvent;
import food_ordering.context.transaction_context.events.OnSelectTransactionHeader;
import food_ordering.context.transaction_context.models.TransactionHeader;
import utility.Auth;
import utility.UtilityPage;

public class HomePage {
	public HomePage() {
		int opt = 0;
		
		do {
			UtilityPage.changePage();
			headerPage();
			latestTransactionPage();
			menuDisplay();
			opt = UtilityPage.getOption(1, 4);
			switch(opt) {
				case 1:
					GoToShopCatalogueEvent.run();
					break;
				case 2:
					GoToCartEvent.run();
					break;
				case 3:
					GoToTransactionHistoryPageEvent.run();
					break;
			}
		}while(opt!=4);
		LogoutEvent.run();
	}
	
	public void menuDisplay() {
		System.out.println("=======================================");
		System.out.println("User Menu");
		System.out.println("1. Shop Menu");
		System.out.println("2. Cart Menu");
		System.out.println("3. Transaction history menu");
		System.out.println("4. Logout");
	}
	
	private void headerPage() {
		User user = Auth.getInstance().getCurrentUser();
		System.out.println("Hello " + user.getName().getLastName() + ", " + user.getName().getFirstName());
	}
	
	private void latestTransactionPage() {
		TransactionHeader lh = OnSelectTransactionHeader.getLatestTransaction();
		if(lh == null) {
			System.out.println("No Transaction yet");
		}else {
			System.out.println("Your latest transaction with ID" + lh.getTransactionID() + " is scheduled for " + lh.getStringPickupDateFormat());
		}
	}
}
