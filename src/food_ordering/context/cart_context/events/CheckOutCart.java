package food_ordering.context.cart_context.events;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import food_ordering.context.cart_context.models.entity.Cart;
import food_ordering.context.transaction_context.events.OnSelectTransactionHeader;

public class CheckOutCart {
    public static String checkOutCarts(String pickupDateTime, ArrayList<Cart> cartList) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date pickupDate = null;
		try {
			pickupDate = dateFormat.parse(pickupDateTime);
		} catch (ParseException e1) {
		}
		java.util.Date transDate = null;
		LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String transDateString = currentDateTime.format(formatter);
		try {
			transDate = dateFormat.parse(transDateString);
		} catch (ParseException e) {
		}
		OnSelectTransactionHeader.insertNewTransaction(transDate, pickupDate, cartList);
		RemoveCart.clearCarts();
		return OnSelectTransactionHeader.getAllTransactionHeaders().get(OnSelectTransactionHeader.getAllTransactionHeaders().size() - 1).getTransactionID();
    }
}
