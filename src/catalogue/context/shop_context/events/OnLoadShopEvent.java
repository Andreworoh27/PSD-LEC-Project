package catalogue.context.shop_context.events;

import java.util.ArrayList;

import catalogue.context.shop_context.controller.models.entity.Shop;
import catalogue.context.shop_context.controller.models.value_object.ShopController;

public class OnLoadShopEvent {
	public static ArrayList<Shop> run(){
		return ShopController.getAllShop();
	}
}
