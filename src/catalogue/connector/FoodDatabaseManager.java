package catalogue.connector;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import catalogue.context.food_context.controller.FoodController;
import catalogue.context.food_context.factory.FoodFactory;
import catalogue.context.food_context.models.entity.Food;
import catalogue.context.food_context.models.value_object.Price;

public class FoodDatabaseManager {

	private static FoodDatabaseManager instance = null;
	private static String filePath = "./src/database/food.txt"; 
	
	public static FoodDatabaseManager getInstance() {
		if(instance == null) {
			synchronized (FoodDatabaseManager.class) {
				if(instance == null) {
					instance = new FoodDatabaseManager();
				}
			}
		}
		return instance;
	}
	
	private FoodDatabaseManager() {
		
	}
	
	public static ArrayList<Food> getFoodList() {
		ArrayList<Food> foodList = new ArrayList<Food>();
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String line;
			while((line = br.readLine()) != null) {
				String[] value = line.split("#");
				Price price = FoodFactory.createPrice(value[2], Double.parseDouble(value[3]));
				Food food = FoodController.createFood(value[0], value[1], price, value[4]);
				foodList.add(food);
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not found!");
		} catch (IOException e) {
			System.out.println("File Not found!");
		}
		
		return foodList;
	}
}
