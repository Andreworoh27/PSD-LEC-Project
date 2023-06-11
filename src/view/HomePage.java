package view;

import authentication.context.authentication_context.events.LogoutEvent;
import authentication.context.authentication_context.models.entity.User;
import catalogue.context.shop_context.events.GoToShopCatalogueEvent;
import utility.Auth;
import utility.UtilityPage;

public class HomePage {
	public HomePage() {
		int opt = 0;
		
		do {
			headerPage();
			latestTransactionPage();
			menuDisplay();
			opt = UtilityPage.getOption(1, 3);
			switch(opt) {
				case 1:
					GoToShopCatalogueEvent.run();
					break;
				case 2:
					//TODO: GoToCartEvent()
					break;
			}
		}while(opt!=3);
		LogoutEvent.run();
	}
	
	public void menuDisplay() {
		System.out.println("=======================================");
		System.out.println("User Menu");
		System.out.println("1. Shop Menu");
		System.out.println("2. Cart Menu");
		System.out.println("3. Logout");
	}
	
	private void headerPage() {
		User user = Auth.getInstance().getCurrentUser();
		System.out.println("Hello " + user.getName().getLastName() + ", " + user.getName().getFirstName());
	}
	
	private void latestTransactionPage() {
		//TODO: TransactionPage
	}
}
