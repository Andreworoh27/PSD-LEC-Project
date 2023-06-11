package catalogue.context.food_context.factory;

import catalogue.context.food_context.models.entity.Food;
import catalogue.context.food_context.models.value_object.Price;

public class FoodFactory {
	
	public static Price createPrice(String foodCurrency, Double foodValue) {
		return new Price(foodCurrency, foodValue);
	}
	
	public static Food createFood(String foodID, String foodName, Price price, String shopID) {
		Food food = new Food();
		food.setFoodID(foodID);
		food.setFoodName(foodName);
		food.setFoodPrice(price);
		food.setShopID(shopID);
		return food;
	}
}
