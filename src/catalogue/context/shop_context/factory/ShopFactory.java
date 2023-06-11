package catalogue.context.shop_context.factory;

import catalogue.context.shop_context.controller.models.entity.Shop;

public class ShopFactory {
	public static Shop createShop(String shopID, String shopName, String shopDescription) {
		Shop shop = new Shop();
		shop.setShopID(shopID);
		shop.setShopName(shopName);
		shop.setDescription(shopDescription);
		return shop;
	}
}
