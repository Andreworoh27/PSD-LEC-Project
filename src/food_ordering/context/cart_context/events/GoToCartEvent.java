package food_ordering.context.cart_context.events;

import view.CartPage;

public class GoToCartEvent {
	public static void run() {
		new CartPage();
	}
}
