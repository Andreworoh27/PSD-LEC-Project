package authentication.context.handler;

import java.util.ArrayList;
import java.util.List;

import authentication.context.models.User;
import authentication.context.repository.UserRepository;

public class UserHandler {

    public static ArrayList<User> getAllUsers() {
        return UserRepository.getAllUsers();
    }

    public static boolean addNewUser(User newUser) {
        List<User> users = UserRepository.getAllUsers();
        String lastId = users.get(users.size() - 1).getUserId();
        lastId = lastId.replaceAll("[^0-9]", "");
        Integer id = Integer.parseInt(lastId);
        id += 1;
        String currentId = "CS" + String.format("%03d", id);
        newUser.setUserId(currentId);
        return UserRepository.addNewUser(newUser);
    }
}
