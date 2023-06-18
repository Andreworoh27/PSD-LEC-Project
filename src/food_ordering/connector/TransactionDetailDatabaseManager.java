package food_ordering.connector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import catalogue.context.food_context.events.FoodOnChosenEvent;
import catalogue.context.food_context.models.entity.Food;
import food_ordering.context.transaction_context.models.entity.TransactionDetail;

public class TransactionDetailDatabaseManager {
    private static TransactionDetailDatabaseManager instance = null;

    private static ArrayList<TransactionDetail> transactionDetails = new ArrayList<>();

    public static TransactionDetailDatabaseManager getInstance() {
        if (instance == null) {
            synchronized (TransactionDetailDatabaseManager.class) {
                if (instance == null) {
                    return instance = new TransactionDetailDatabaseManager();
                }
            }
        }
        return instance;
    }

    public static void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line using "#" as the separator
                String[] values = line.split("#");

                // Access the values
                String transactionId = values[0];
                String foodId = values[1];
                Integer quantity = Integer.parseInt(values[2]);
                String notes = values[3];

                Food food = FoodOnChosenEvent.getFoodById(foodId);

                TransactionDetail newDetail = new TransactionDetail(transactionId, food, quantity, notes);
                transactionDetails.add(newDetail);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendToFile(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Append the data to the file
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("File Not found!");
        }
    }

    public boolean addNewTransactionDetails(TransactionDetail transactionDetail) {
        String data = transactionDetail.getTransactionId() + "#" + transactionDetail.getFood().getFoodID() + "#"
                + transactionDetail.getQuantity().toString() + "#" + transactionDetail.getNotes();
        String filePath = "./src/database/transactionDetail.txt";
        appendToFile(filePath, data);
        transactionDetails.add(transactionDetail);
        return true;
    }

    public ArrayList<TransactionDetail> getTransactionDetails() {
        transactionDetails.clear();
        readFile("./src/database/transactionDetail.txt");
        return transactionDetails;
    }
}
