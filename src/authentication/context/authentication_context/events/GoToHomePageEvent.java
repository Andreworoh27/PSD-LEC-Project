package authentication.context.authentication_context.events;

import view.HomePage;

public class GoToHomePageEvent {
	public static void run() {
		new HomePage();
	}
}
