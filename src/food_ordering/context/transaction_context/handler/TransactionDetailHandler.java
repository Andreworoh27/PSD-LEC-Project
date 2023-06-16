package food_ordering.context.transaction_context.handler;

import java.util.ArrayList;

import food_ordering.context.transaction_context.controller.TransactionHeaderController;
import food_ordering.context.transaction_context.models.TransactionDetail;
import food_ordering.context.transaction_context.models.TransactionHeader;
import food_ordering.context.transaction_context.repository.TransactionDetailRepository;

public class TransactionDetailHandler {
    public static ArrayList<TransactionDetail> getAllTransactionDetails() {
        return TransactionDetailRepository.getAllTransactionDetails();
    }
}
