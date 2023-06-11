package authentication.context.authentication_context.models.Entity;

import authentication.context.authentication_context.models.ValueObject.Name;

public class User {
    Name name;
    String userName;
    String userId;
    String userPassword;

    public User(String userId, String userName, Name name, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.name = name;
        this.userPassword = userPassword;
    }

    public Name getName() {
        return name;
    }
    public String getUserPassword() {
        return userPassword;
    }
    public String getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setName(Name name) {
        this.name = name;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
