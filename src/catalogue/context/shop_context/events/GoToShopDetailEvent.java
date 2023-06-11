package catalogue.context.shop_context.events;

import view.ShopDetailPage;

public class GoToShopDetailEvent {
	public static void run(String shopID) {
		new ShopDetailPage(shopID);
	}
}
