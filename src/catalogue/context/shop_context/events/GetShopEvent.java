package catalogue.context.shop_context.events;

import catalogue.context.shop_context.controller.ShopController;
import catalogue.context.shop_context.models.entity.Shop;

public class GetShopEvent {
	public static Shop run(String ShopID) {
		return ShopController.getShop(ShopID);
	}
}
