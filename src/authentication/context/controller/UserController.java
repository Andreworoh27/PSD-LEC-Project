package authentication.context.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

import authentication.context.handler.UserHandler;
import authentication.context.models.User;

public class UserController{

    public static ArrayList<User> getAllUsers(){
        return UserHandler.getAllUsers();
    }

    public static boolean addNewUser(User newUser){
        return UserHandler.addNewUser(newUser);
    }
}