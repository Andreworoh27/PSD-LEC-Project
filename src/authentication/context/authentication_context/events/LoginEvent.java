package authentication.context.authentication_context.events;

import java.util.ArrayList;

import authentication.context.authentication_context.controller.UserController;
import authentication.context.authentication_context.models.entity.User;
import utility.Auth;

public class LoginEvent {
    private static Auth auth = Auth.getInstance();
    public static Boolean login(String name, String password){
        ArrayList<User> users = UserController.getAllUsers();
        for (User user : users) {
            if(name.equals(user.getUserName()) && password.equals(user.getUserPassword())){
                auth.setCurrentUser(user);
                auth.setAuthenticate(true);
                return true;
            }
        }
        return false;
    }
}
