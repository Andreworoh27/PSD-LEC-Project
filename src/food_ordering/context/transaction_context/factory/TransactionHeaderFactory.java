package food_ordering.context.transaction_context.factory;

import java.util.ArrayList;
import java.util.Date;

import authentication.context.authentication_context.models.entity.User;
import food_ordering.context.cart_context.models.entity.Cart;
import food_ordering.context.transaction_context.models.TransactionDetail;
import food_ordering.context.transaction_context.models.TransactionHeader;

public class TransactionHeaderFactory {
    public static TransactionHeader makeNewTransactionHeader(String transactionId, User buyer, Date transactionDate, Date pickupDate, ArrayList<TransactionDetail> details){
        return new TransactionHeader(transactionId, buyer, transactionDate, pickupDate, details);
    }
}
