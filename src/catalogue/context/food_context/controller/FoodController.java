package catalogue.context.food_context.controller;

import java.util.ArrayList;

import catalogue.context.food_context.handler.FoodHandler;
import catalogue.context.food_context.models.entity.Food;
import catalogue.context.food_context.models.value_object.Price;
import catalogue.context.food_context.repository.FoodRepository;

public class FoodController {
	public static Food createFood(String foodID, String foodName, Price price, String shopID){
		return FoodHandler.createFood(foodID, foodName, price, shopID);
	}
	
	public static ArrayList<Food> getAllFood(){
		return FoodHandler.getAllFood();
	}
	
	public static ArrayList<Food> getfoodShop(String shopID){
		return FoodHandler.getfoodShop(shopID);
	}
}
