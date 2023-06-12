package authentication.context.authentication_context.events;

import authentication.context.authentication_context.controller.UserController;
import authentication.context.authentication_context.models.entity.User;

public class GetUserEvent {
	public static User run(String userID) {
		return UserController.getUser(userID);
	}
}
