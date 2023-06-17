package food_ordering.context.cart_context.events;

import java.util.List;

import food_ordering.context.cart_context.controller.CartController;
import food_ordering.context.cart_context.models.entity.Cart;

public class GetAllCart {
    public static List<Cart> getAllCarts(){
        return CartController.getAllCarts();
    }
}
