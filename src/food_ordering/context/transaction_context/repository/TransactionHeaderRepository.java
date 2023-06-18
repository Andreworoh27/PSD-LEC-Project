package food_ordering.context.transaction_context.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import authentication.context.authentication_context.models.entity.User;
import catalogue.context.food_context.models.entity.Food;
import food_ordering.connector.TransactionDetailDatabaseManager;
import food_ordering.connector.TransactionHeaderDatabaseManager;
import food_ordering.context.cart_context.models.entity.Cart;
import food_ordering.context.transaction_context.events.OnSelectTransactionDetail;
import food_ordering.context.transaction_context.factory.TransactionDetailFactory;
import food_ordering.context.transaction_context.factory.TransactionHeaderFactory;
import food_ordering.context.transaction_context.models.TransactionDetail;
import food_ordering.context.transaction_context.models.TransactionHeader;
import utility.Auth;

public class TransactionHeaderRepository {
    private static TransactionHeaderDatabaseManager db = TransactionHeaderDatabaseManager.getInstance();
    private static Auth auth = Auth.getInstance();

    public static ArrayList<TransactionHeader> getAllTransactionHeader(String UserId) {
        ArrayList<TransactionHeader> transactionHeaders = db.getTransactionHeaders();

        ArrayList<TransactionHeader> filtered = new ArrayList<>();
        User currentUser = auth.getCurrentUser();

        for (TransactionHeader transactionHeader : transactionHeaders) {
            if (transactionHeader.getBuyer().getUserId().equals(currentUser.getUserId())) {
                filtered.add(transactionHeader);
            }
        }
        return filtered;
    }

    public static boolean addNewTransaction(String transactionId, User buyer, Date transactionDate, Date pickupDate,
            ArrayList<Cart> cartlist) {
        ArrayList<TransactionDetail> td = new ArrayList<>();

        for (Cart cart : cartlist) {
            Food food = cart.getFood();
            Integer quantity = cart.getQuantity();
            String notes = cart.getNotes();
            TransactionDetail newDetail = TransactionDetailFactory.createNewTransactionDetail(transactionId, food,
                    quantity, notes);
            td.add(newDetail);
        }

        TransactionHeader th = TransactionHeaderFactory.makeNewTransactionHeader(transactionId, buyer, transactionDate,
                pickupDate, td);
        db.addNewTransactionHeader(th);

        TransactionDetailDatabaseManager tdDb = TransactionDetailDatabaseManager.getInstance();
        for (TransactionDetail transactionDetail : td) {
            tdDb.addNewTransactionDetails(transactionDetail);
        }
        return true;
    }
    
    public static ArrayList<TransactionHeader> getAllTransactionHeader() {
        return db.getTransactionHeaders();
    }
    
    public static TransactionHeader getHeaderById(String transactionId) {
    	for(TransactionHeader h : db.getTransactionHeaders()) {
    		if(h.getTransactionID().equals(transactionId)) {
    			return h;
    		}
    	}
    	return null;
    }
    
    public static TransactionHeader getLatestTransaction(String userId) {
    	TransactionHeader header = null;
    	for(TransactionHeader h : getAllTransactionHeader(userId)) {
    		if(header == null) {
    			header = h;
    		}else if(header.getTransactionDate().before(h.getTransactionDate())) {
    			header = h;
    		}
    	}
    	return header;
    }
}
