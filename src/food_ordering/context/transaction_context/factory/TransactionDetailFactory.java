package food_ordering.context.transaction_context.factory;

import catalogue.context.food_context.models.entity.Food;
import food_ordering.context.transaction_context.models.TransactionDetail;

public class TransactionDetailFactory {
    public static TransactionDetail createNewTransactionDetail(String transactionId, Food food, Integer quantity, String notes){
        return new TransactionDetail(transactionId, food, quantity, notes);
    }
}
