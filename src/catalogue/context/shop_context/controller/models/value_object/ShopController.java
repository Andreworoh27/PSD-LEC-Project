package catalogue.context.shop_context.controller.models.value_object;

import java.util.ArrayList;

import catalogue.context.shop_context.controller.models.entity.Shop;
import catalogue.context.shop_context.handler.ShopHandler;

public class ShopController {
	public static ArrayList<Shop> getAllShop(){
		return ShopHandler.getAllShop();
	}
	
	public static Shop createShop(String shopID, String shopName, String shopDescription) {
		return ShopHandler.createShop(shopID, shopName, shopDescription);
	}
}
