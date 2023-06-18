package authentication.context.authentication_context.events;

import food_ordering.context.cart_context.events.RemoveCart;
import utility.Auth;

public class LogoutEvent {
	public static void run() {
		Auth.getInstance().setCurrentUser(null);
		Auth.getInstance().setAuthenticate(false);
		RemoveCart.clearCarts();
	}
}
