package food_ordering.context.transaction_context.events;

import java.util.ArrayList;

import food_ordering.context.transaction_context.controller.TransactionDetailController;
import food_ordering.context.transaction_context.models.TransactionDetail;

public class OnSelectTransactionDetail {
    public static ArrayList<TransactionDetail> getAllTransactionDetails(){
        return TransactionDetailController.getAllTransactionDetails();
    }
    
    public static ArrayList<TransactionDetail> getDetailTransaction(String trId){
    	return TransactionDetailController.getDetailTransaction(trId);
    }
}
