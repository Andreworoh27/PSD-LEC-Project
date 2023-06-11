package authentication.context.authentication_context.events;

import authentication.context.authentication_context.models.Entity.User;

public class Authentication {
    private User currentUser;

    private static Authentication instace = null;
    private static boolean isAuthenticate = false;

    public static Authentication getInstance() {
        if (instace == null) {
            synchronized (Authentication.class) {
                if (instace == null) {
                    instace = new Authentication();
                }
            }
        }
        return instace;
    }
    
    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void setAuthenticate(boolean isAuthenticate) {
        Authentication.isAuthenticate = isAuthenticate;
    }

    public static boolean getIsAuthenticate() {
        return isAuthenticate;
    }
}
