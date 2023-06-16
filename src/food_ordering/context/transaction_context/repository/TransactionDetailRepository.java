package food_ordering.context.transaction_context.repository;

import java.util.ArrayList;

import food_ordering.connector.TransactionDetailDatabaseManager;
import food_ordering.context.transaction_context.models.TransactionDetail;

public class TransactionDetailRepository {
    static TransactionDetailDatabaseManager db = TransactionDetailDatabaseManager.getInstance();
    public static ArrayList<TransactionDetail> getAllTransactionDetails(){
        return db.getTransactionDetails();
    }
}
