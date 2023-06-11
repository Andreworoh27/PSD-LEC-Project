package authentication.context.authentication_context.events;

import utility.Auth;

public class LogoutEvent {
	public static void run() {
		Auth.getInstance().setCurrentUser(null);
		Auth.getInstance().setAuthenticate(false);
	}
}
