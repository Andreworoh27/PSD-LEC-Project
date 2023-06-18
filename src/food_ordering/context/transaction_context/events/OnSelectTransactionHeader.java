package food_ordering.context.transaction_context.events;

import java.util.Date;
import java.util.ArrayList;

import authentication.context.authentication_context.models.entity.User;
import food_ordering.context.cart_context.models.entity.Cart;
import food_ordering.context.transaction_context.controller.TransactionHeaderController;
import food_ordering.context.transaction_context.models.entity.TransactionHeader;
import utility.Auth;

public class OnSelectTransactionHeader {
    private static Auth auth = Auth.getInstance();

    public static ArrayList<TransactionHeader> getAllTransactionHeaders() {
        User user = auth.getCurrentUser();
        return TransactionHeaderController.getAllTransactionHeader(user.getUserId());
    }

    public static boolean insertNewTransaction(Date transactionDate, Date pickupDate, ArrayList<Cart> cartlist){
        User user = auth.getCurrentUser();
        TransactionHeaderController.addNewTransaction(user,transactionDate,pickupDate,cartlist);
        return true;
    }
    
    public static TransactionHeader getHeaderById(String transactionId) {
    	return TransactionHeaderController.getHeaderById(transactionId);
    }
    
    public static TransactionHeader getLatestTransaction() {
    	User user = auth.getCurrentUser();
    	return TransactionHeaderController.getLatestTransaction(user.getUserId());
    }
}
