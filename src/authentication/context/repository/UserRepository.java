package authentication.context.repository;

import java.util.ArrayList;
import java.util.List;

import authentication.context.models.User;
import authentication.database.UserDatabaseManager;

public class UserRepository {
    private static UserDatabaseManager db = UserDatabaseManager.getInstance();

    public static ArrayList<User> getAllUsers(){
        return db.getUserslList();
    }

    public static boolean addNewUser(User user){
        return db.addNewUser(user);
    }
}
