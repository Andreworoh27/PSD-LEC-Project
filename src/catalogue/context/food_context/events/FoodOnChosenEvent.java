package catalogue.context.food_context.events;

import catalogue.context.food_context.controller.FoodController;
import catalogue.context.food_context.models.entity.Food;

public class FoodOnChosenEvent {
    public static Food getFoodById(String foodId){
        Food food = FoodController.getFoodById(foodId);
        return food;
    }
}
