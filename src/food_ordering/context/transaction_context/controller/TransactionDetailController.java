package food_ordering.context.transaction_context.controller;

import java.util.ArrayList;

import food_ordering.context.transaction_context.handler.TransactionDetailHandler;
import food_ordering.context.transaction_context.handler.TransactionHeaderHandler;
import food_ordering.context.transaction_context.models.entity.TransactionDetail;
import food_ordering.context.transaction_context.models.entity.TransactionHeader;
import food_ordering.context.transaction_context.repository.TransactionHeaderRepository;

public class TransactionDetailController {
    public static ArrayList<TransactionDetail> getAllTransactionDetails(){
        return TransactionDetailHandler.getAllTransactionDetails();
    }
    
    public static ArrayList<TransactionDetail> getDetailTransaction(String trId){
    	return TransactionDetailHandler.getDetailTransaction(trId);
    }
}
