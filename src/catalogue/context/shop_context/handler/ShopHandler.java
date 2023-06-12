package catalogue.context.shop_context.handler;

import java.util.ArrayList;

import catalogue.context.shop_context.models.entity.Shop;
import catalogue.context.shop_context.repository.ShopRepository;

public class ShopHandler {
	public static ArrayList<Shop> getAllShop(){
		return ShopRepository.getAllShop();
	}
	
	public static Shop createShop(String shopID, String shopName, String shopDescription) {
		return ShopRepository.createShop(shopID, shopName, shopDescription);
	}
	
	public static Shop getShop(String shopID) {
		return ShopRepository.getShop(shopID);
	}
}
