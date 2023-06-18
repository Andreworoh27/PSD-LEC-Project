package authentication.context.authentication_context.events;

import view.AuthenticationPage;

public class OnStartEvent {
	public static void run() {
		new AuthenticationPage();
	}
}
