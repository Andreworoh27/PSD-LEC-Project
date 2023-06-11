package catalogue.context.shop_context.events;

import java.util.ArrayList;

import catalogue.context.food_context.controller.FoodController;
import catalogue.context.food_context.models.entity.Food;

public class OnChosenShopEvent {
	
	public static ArrayList<Food> run(String shopID) {
		return FoodController.getfoodShop(shopID);
	}
}
