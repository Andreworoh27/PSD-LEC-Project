package catalogue.context.food_context.events;

import catalogue.context.food_context.controller.FoodController;
import catalogue.context.food_context.models.entity.Food;

public class OnGetFoodEvent {
	public static Food getFoodById(String foodID) {
		return FoodController.getFoodById(foodID);
	}
}
