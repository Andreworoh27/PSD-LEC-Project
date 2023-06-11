package catalogue.context.shop_context.events;

import view.ShopCataloguePage;

public class GoToShopCatalogueEvent {
	public static void run() {
		new ShopCataloguePage();
	}
}
