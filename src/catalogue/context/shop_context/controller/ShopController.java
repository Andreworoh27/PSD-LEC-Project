package catalogue.context.shop_context.controller;

import java.util.ArrayList;

import catalogue.context.shop_context.handler.ShopHandler;
import catalogue.context.shop_context.models.entity.Shop;

public class ShopController {
	public static ArrayList<Shop> getAllShop(){
		return ShopHandler.getAllShop();
	}
	
	public static Shop createShop(String shopID, String shopName, String shopDescription) {
		return ShopHandler.createShop(shopID, shopName, shopDescription);
	}
	
	public static Shop getShop(String shopID) {
		return ShopHandler.getShop(shopID);
	}
}
