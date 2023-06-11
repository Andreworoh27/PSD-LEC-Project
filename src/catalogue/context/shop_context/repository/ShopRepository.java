package catalogue.context.shop_context.repository;

import java.util.ArrayList;

import catalogue.connector.ShopDatabaseManager;
import catalogue.context.food_context.events.OnLoadShopEvent;
import catalogue.context.shop_context.controller.models.entity.Shop;
import catalogue.context.shop_context.factory.ShopFactory;

public class ShopRepository {
	private static ShopDatabaseManager db = ShopDatabaseManager.getInstance();
	public static ArrayList<Shop> getAllShop(){
		return db.getShopList();
	}
	
	public static Shop createShop(String shopID, String shopName, String shopDescription) {
		Shop shop = ShopFactory.createShop(shopID, shopName, shopDescription);
		shop.setListOfFood(OnLoadShopEvent.getShopFood(shopID));
		return shop;
	}	
}
