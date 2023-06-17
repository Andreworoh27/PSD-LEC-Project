package food_ordering.context.cart_context.handler;

import java.util.ArrayList;

import catalogue.context.food_context.models.entity.Food;
import food_ordering.context.cart_context.controller.CartController;
import food_ordering.context.cart_context.models.entity.Cart;
import food_ordering.context.cart_context.repository.CartRepository;

public class CartHandler {
    public static boolean addNewCart(Food food, Integer quantity, String notes) {
        return CartRepository.addNewCart(food, quantity, notes);
    }

    public static boolean removeCartByIndex(int idx) {
        return CartRepository.removeCartByIndex(idx);
    }

    public static boolean clearCarts() {
        return CartRepository.clearCarts();
    }

    public static ArrayList<Cart> getAllCarts(){
        return CartRepository.getAllCarts();
    }
}
