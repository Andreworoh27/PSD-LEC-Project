package catalogue.context.food_context.repository;

import java.util.ArrayList;

import catalogue.connector.FoodDatabaseManager;
import catalogue.context.food_context.factory.FoodFactory;
import catalogue.context.food_context.models.entity.Food;
import catalogue.context.food_context.models.value_object.Price;

public class FoodRepository {
	private static FoodDatabaseManager db = FoodDatabaseManager.getInstance();
	
	public static ArrayList<Food> getAllFood() {
		return db.getFoodList();
	}
	
	public static ArrayList<Food> getFoodShop(String shopID){
		ArrayList<Food> foodShop = new ArrayList<Food>();
		for(Food f : getAllFood()) {
			if(f.getShopID().equals(shopID)) {
				foodShop.add(f);
			}
		}
		return foodShop;
	}
	
	public static Food createFood(String foodID, String foodName, Price price, String shopID) {
		return FoodFactory.createFood(foodID, foodName, price, shopID);
	}

	public static Food getFoodById(String foodId){
		ArrayList<Food> foods = db.getFoodList();
		for (Food food : foods) {
			if(food.getFoodID().equals(foodId)){
				return food;
			}
		}
		return null;
	}
}
