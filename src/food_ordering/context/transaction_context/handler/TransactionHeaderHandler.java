package food_ordering.context.transaction_context.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import authentication.context.authentication_context.models.entity.User;
import food_ordering.context.cart_context.models.entity.Cart;
import food_ordering.context.transaction_context.models.TransactionHeader;
import food_ordering.context.transaction_context.repository.TransactionHeaderRepository;

public class TransactionHeaderHandler {
    public static ArrayList<TransactionHeader> getAllTransactionHeader(String UserId) {
        return TransactionHeaderRepository.getAllTransactionHeader(UserId);
    }

    public static boolean addNewTransaction(User buyer, Date transactionDate, Date pickupDate,
            ArrayList<Cart> cartlist) {
        ArrayList<TransactionHeader> headers = TransactionHeaderRepository.getAllTransactionHeader();
        
        String lastId = headers.get(headers.size() -1).getTransactionID();
        lastId = lastId.replaceAll("[^0-9]", "");
        Integer id = Integer.parseInt(lastId);
        id += 1;
        String currentId = "TR" + String.format("%03d", id);

        return TransactionHeaderRepository.addNewTransaction(currentId, buyer, transactionDate, pickupDate, cartlist);
    }
    
    public static TransactionHeader getHeaderById(String transactionId) {
    	return TransactionHeaderRepository.getHeaderById(transactionId);
    }
    
    public static TransactionHeader getLatestTransaction(String userId) {
    	return TransactionHeaderRepository.getLatestTransaction(userId);
    }
}
