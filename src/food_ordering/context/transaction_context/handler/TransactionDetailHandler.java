package food_ordering.context.transaction_context.handler;

import java.util.ArrayList;

import food_ordering.context.transaction_context.controller.TransactionHeaderController;
import food_ordering.context.transaction_context.models.entity.TransactionDetail;
import food_ordering.context.transaction_context.models.entity.TransactionHeader;
import food_ordering.context.transaction_context.repository.TransactionDetailRepository;

public class TransactionDetailHandler {
    public static ArrayList<TransactionDetail> getAllTransactionDetails() {
        return TransactionDetailRepository.getAllTransactionDetails();
    }
    public static ArrayList<TransactionDetail> getDetailTransaction(String trId){
    	return TransactionDetailRepository.getDetailTransaction(trId);
    }
}
