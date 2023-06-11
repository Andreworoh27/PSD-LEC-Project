package authentication.context.authentication_context.controller;

import java.util.ArrayList;

import authentication.context.authentication_context.handler.UserHandler;
import authentication.context.authentication_context.models.entity.User;

public class UserController{

    public static ArrayList<User> getAllUsers(){
        return UserHandler.getAllUsers();
    }

    public static boolean addNewUser(User newUser){
        return UserHandler.addNewUser(newUser);
    }
}