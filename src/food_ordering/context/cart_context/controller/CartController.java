package food_ordering.context.cart_context.controller;

import java.util.ArrayList;

import catalogue.context.food_context.models.entity.Food;
import food_ordering.context.cart_context.handler.CartHandler;
import food_ordering.context.cart_context.models.entity.Cart;
import food_ordering.context.cart_context.repository.CartRepository;

public class CartController {
    public static boolean addNewCart(Food food, Integer quantity, String notes) {
        return CartHandler.addNewCart(food, quantity, notes);
    }

    public static boolean removeCartByIndex(int idx) {
        return CartHandler.removeCartByIndex(idx - 1);
    }

    public static boolean clearCarts() {
        return CartHandler.clearCarts();
    }

    public static ArrayList<Cart> getAllCarts() {
        return CartHandler.getAllCarts();
    }
}
