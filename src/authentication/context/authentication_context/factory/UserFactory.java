package authentication.context.authentication_context.factory;

import authentication.context.authentication_context.models.entity.User;
import authentication.context.authentication_context.models.value_object.Name;

public class UserFactory {

    public static User createNewUser(String userName, String firstName, String lastName, String password) {
        User user = new User(userName, userName, new Name(firstName, lastName), password);
        return user;
    }
}
