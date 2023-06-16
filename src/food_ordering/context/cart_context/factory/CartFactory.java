package food_ordering.context.cart_context.factory;

import catalogue.context.food_context.models.entity.Food;
import food_ordering.context.cart_context.models.entity.Cart;

public class CartFactory {
    public static Cart createNewCart(Food food, Integer quantity, String notes){
        Cart newCart = new Cart(food, quantity, notes);
        return newCart;
    }
}
