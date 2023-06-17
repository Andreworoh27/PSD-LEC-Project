package food_ordering.context.cart_context.repository;

import java.util.ArrayList;
import java.util.List;

import catalogue.context.food_context.models.entity.Food;
import food_ordering.context.cart_context.factory.CartFactory;
import food_ordering.context.cart_context.models.entity.Cart;
import food_ordering.context.cart_context.storage.CartStorageManager;

public class CartRepository {
    private static CartStorageManager db = CartStorageManager.getInstance();

    public static boolean addNewCart(Food food, Integer quantity, String notes) {
        Cart cart = CartFactory.createNewCart(food, quantity, notes);
        db.addToCarts(cart);
        return true;
    }

    public static boolean removeCartByIndex(int idx){
        return db.removeCartByIndex(idx);
    }

    public static boolean clearCarts(){
        db.clearCarts();
        return true;
    }

    public static ArrayList<Cart> getAllCarts(){
        return db.getCarts();
    }
}
