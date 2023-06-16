package food_ordering.context.cart_context.storage;

import java.util.ArrayList;
import java.util.List;

import food_ordering.context.cart_context.models.entity.Cart;
import utility.Auth;

public class CartStorageManager {
    private static ArrayList<Cart> carts = new ArrayList<>();
    private static CartStorageManager instance = null;

    public static CartStorageManager getInstance(){
        if (instance == null) {
            synchronized (Auth.class) {
                if (instance == null) {
                    instance = new CartStorageManager();
                }
            }
        }
        return instance;
    }

    public static ArrayList<Cart> getCarts() {
        return carts;
    }

    public static void addToCarts(Cart cart){
        carts.add(cart);
    }

    public static void clearCarts(){
        carts.clear();
    }

    public static boolean removeCartByIndex(int idx){
        carts.remove(idx);
        return true;
    }
}
