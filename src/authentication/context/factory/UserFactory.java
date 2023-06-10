package authentication.context.factory;

import authentication.context.models.User;
import authentication.context.models.ValueObject.Name;

public class UserFactory {

    public static User createNewUser(String userName, String firstName, String lastName, String password) {
        User user = new User(userName, userName, new Name(firstName, lastName), password);
        return user;
    }
}
