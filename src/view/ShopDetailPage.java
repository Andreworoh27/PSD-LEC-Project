package view;

import catalogue.context.food_context.models.entity.Food;
import catalogue.context.shop_context.events.OnChosenShopEvent;

public class ShopDetailPage {
	public ShopDetailPage(String shopID) {
		foodDisplay(shopID);
	}
	
	public int foodDisplay(String shopID) {
		int count = 0;
		for(Food f : OnChosenShopEvent.run(shopID)) {
			System.out.println(f.getFoodName());
			count++;
		}
		return count;
	}
}
