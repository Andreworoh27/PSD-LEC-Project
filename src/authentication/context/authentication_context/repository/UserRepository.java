package authentication.context.authentication_context.repository;

import java.util.ArrayList;

import authentication.connector.UserDatabaseManager;
import authentication.context.authentication_context.models.entity.User;

public class UserRepository {
    private static UserDatabaseManager db = UserDatabaseManager.getInstance();

    public static ArrayList<User> getAllUsers(){
        return db.getUserslList();
    }

    public static boolean addNewUser(User user){
        return db.addNewUser(user);
    }
}
