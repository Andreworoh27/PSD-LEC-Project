package authentication.connector;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import authentication.context.authentication_context.models.entity.User;
import authentication.context.authentication_context.models.value_object.Name;

public class UserDatabaseManager {
    private static ArrayList<User> usersList = new ArrayList<>();

    private static UserDatabaseManager instance = null;

    public static UserDatabaseManager getInstance() {
        if (instance == null) {
            synchronized (UserDatabaseManager.class) {
                if (instance == null) {
                    instance = new UserDatabaseManager();
                }
            }
        }
        return instance;
    }

    private UserDatabaseManager() {

    }

    public static void readFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line using "#" as the separator
                String[] values = line.split("#");

                // Access the values
                String userId = values[0];
                String userName = values[1];
                Name name = new Name(values[2], values[3]);
                String userPassword = values[4];
                User user = new User(userId, userName, name, userPassword);
                usersList.add(user);

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

    public ArrayList<User> getUserslList() {
        usersList.clear();
        readFile("./src/database/user.txt");
        return usersList;
    }

    public boolean addNewUser(User user) {
        String data = user.getUserId() + "#" + user.getUserName() + "#" + user.getName().getFirstName() + "#"
                + user.getName().getLastName() + "#" + user.getUserPassword();
        String filePath = "./src/database/user.txt";
        appendToFile(filePath, data);
        usersList.add(user);
        return true;
    }
}
