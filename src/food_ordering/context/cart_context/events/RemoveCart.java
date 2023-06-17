package food_ordering.context.cart_context.events;

import food_ordering.context.cart_context.controller.CartController;

public class RemoveCart {
    // remove cart with the index given (no need to decrement the index by 1).
    public static boolean removeCartByIndex(int idx){
        return CartController.removeCartByIndex(idx);
    }

    // clear all cart when checkout or user want to delete all carts
    public static boolean clearCarts(){
        return CartController.clearCarts();
    }
}
