package food_ordering.connector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import authentication.context.authentication_context.controller.UserController;
import authentication.context.authentication_context.events.GetUserEvent;
import authentication.context.authentication_context.models.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import food_ordering.context.transaction_context.events.OnSelectTransactionDetail;
import food_ordering.context.transaction_context.models.entity.TransactionDetail;
import food_ordering.context.transaction_context.models.entity.TransactionHeader;

public class TransactionHeaderDatabaseManager {
    private static ArrayList<TransactionHeader> transactionheaders = new ArrayList<>();

    private static TransactionHeaderDatabaseManager instance = null;

    public static TransactionHeaderDatabaseManager getInstance() {
        if (instance == null) {
            synchronized (TransactionHeaderDatabaseManager.class) {
                if (instance == null) {
                    return instance = new TransactionHeaderDatabaseManager();
                }
            }
        }
        return instance;
    }

    public static void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            while ((line = br.readLine()) != null) {
                // Split the line using "#" as the separator
                String[] values = line.split("#");

                // Access the values
                String transactionId = values[0];
                String userId = values[1];
                Date pickupDate = null;
                Date transactionDate = null;
                try {
                    pickupDate = dateFormat.parse(values[2]);
                } catch (ParseException e) {
                    System.out.println("parse pickup date failed");
                    e.printStackTrace();
                }
                try {
                    transactionDate = dateFormat.parse(values[3]);
                } catch (ParseException e) {
                    System.out.println("parse transaction date failed");
                    e.printStackTrace();
                }
                if (pickupDate == null || transactionDate == null) {
                    System.out.println("Read Date error, break loop");
                    break;
                }


                TransactionDetailDatabaseManager db = TransactionDetailDatabaseManager.getInstance();
                ArrayList<TransactionDetail> details = OnSelectTransactionDetail.getAllTransactionDetails();

                ArrayList<TransactionDetail> filtered = new ArrayList<>();
                for (TransactionDetail transactionDetail : details) {
                    if (transactionDetail.getTransactionId().equals(transactionId)) {
                        filtered.add(transactionDetail);
                    }
                }

                User currentUser = UserController.getUser(userId);
                
                TransactionHeader newHeader = new TransactionHeader(transactionId, currentUser, transactionDate,
                        pickupDate, filtered);
                transactionheaders.add(newHeader);
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

    public boolean addNewTransactionHeader(TransactionHeader transactionHeader) {
        String data = transactionHeader.getTransactionID() + "#" + transactionHeader.getBuyer().getUserId() + "#"
                + transactionHeader.getStringPickupDateFormat() + "#"
                + transactionHeader.getStringTransactionDateFormat();
        String filePath = "./src/database/transactionHeader.txt";
        appendToFile(filePath, data);
        transactionheaders.add(transactionHeader);
        return true;
    }

    public ArrayList<TransactionHeader> getTransactionHeaders() {
        transactionheaders.clear();
        readFile("./src/database/transactionHeader.txt");
        return transactionheaders;
    }
}
