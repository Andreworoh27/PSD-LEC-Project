package authentication.context.authentication_context.events;

import authentication.context.authentication_context.controller.UserController;
import authentication.context.authentication_context.factory.UserFactory;
import authentication.context.authentication_context.models.Entity.User;

public class Register {
    public static boolean register(String userName, String firstName, String lastName, String password) {

        User newUser = UserFactory.createNewUser(userName, firstName,lastName, password);

        return UserController.addNewUser(newUser);
    }
}
