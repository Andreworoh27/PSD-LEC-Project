package catalogue.context.food_context.handler;

import java.util.ArrayList;

import catalogue.context.food_context.models.entity.Food;
import catalogue.context.food_context.models.value_object.Price;
import catalogue.context.food_context.repository.FoodRepository;

public class FoodHandler {
	public static Food createFood(String foodID, String foodName, Price price, String shopID){
		return FoodRepository.createFood(foodID, foodName, price, shopID);
	}
	
	public static ArrayList<Food> getAllFood(){
		return FoodRepository.getAllFood();
	}
	
	public static ArrayList<Food> getfoodShop(String shopID){
		return FoodRepository.getFoodShop(shopID);
	}
}
