package utility;

import authentication.context.authentication_context.models.entity.User;

public class Auth {
    private User currentUser;

    private static Auth instace = null;
    private static boolean isAuthenticate = false;

    public static Auth getInstance() {
        if (instace == null) {
            synchronized (Auth.class) {
                if (instace == null) {
                    instace = new Auth();
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
        Auth.isAuthenticate = isAuthenticate;
    }

    public static boolean getIsAuthenticate() {
        return isAuthenticate;
    }
}
