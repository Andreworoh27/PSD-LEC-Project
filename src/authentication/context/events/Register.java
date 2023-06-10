package authentication.context.events;

import authentication.context.controller.UserController;
import authentication.context.factory.UserFactory;
import authentication.context.models.User;
import authentication.context.models.ValueObject.Name;

public class Register {
    public static boolean register(String userName, String firstName, String lastName, String password) {

        User newUser = UserFactory.createNewUser(userName, firstName,lastName, password);

        return UserController.addNewUser(newUser);
    }
}
