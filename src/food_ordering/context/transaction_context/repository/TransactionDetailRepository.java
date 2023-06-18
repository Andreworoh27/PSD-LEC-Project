package food_ordering.context.transaction_context.repository;

import java.util.ArrayList;

import food_ordering.connector.TransactionDetailDatabaseManager;
import food_ordering.context.transaction_context.models.TransactionDetail;

public class TransactionDetailRepository {
    static TransactionDetailDatabaseManager db = TransactionDetailDatabaseManager.getInstance();
    public static ArrayList<TransactionDetail> getAllTransactionDetails(){
        return db.getTransactionDetails();
    }
    
    public static ArrayList<TransactionDetail> getDetailTransaction(String trId){
    	ArrayList<TransactionDetail> detailList = new ArrayList<TransactionDetail>();
    	for(TransactionDetail tr : getAllTransactionDetails()) {
    		if(tr.getTransactionId().equals(trId)) {
    			detailList.add(tr);
    		}
    	}
    	return detailList;
    }
}
