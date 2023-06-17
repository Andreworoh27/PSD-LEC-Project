package food_ordering.context.cart_context.events;

import catalogue.context.food_context.models.entity.Food;
import food_ordering.context.cart_context.controller.CartController;

public class AddToCart {
    // add a food to the cart
    public static boolean addNewCart(Food food, Integer quantity, String notes){
        return CartController.addNewCart(food, quantity, notes);
    }
}
