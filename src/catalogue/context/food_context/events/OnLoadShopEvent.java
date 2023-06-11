package catalogue.context.food_context.events;

import java.util.ArrayList;

import catalogue.context.food_context.controller.FoodController;
import catalogue.context.food_context.models.entity.Food;

public class OnLoadShopEvent {
	public static ArrayList<Food> getShopFood(String shopID) {
		return FoodController.getfoodShop(shopID);
	}
}
