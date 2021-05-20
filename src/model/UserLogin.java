package model;

public class UserLogin {
    private String userName;
    private String password;
    private boolean isCurrentlyActive;

    public boolean isCurrentlyActive() {
        return isCurrentlyActive;
    }
    public void setIsCurrentlyActive(boolean isActive) {
        this.isCurrentlyActive = isActive;
    }

    public UserLogin(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean authenticateUser(String password) {
        return(this.password.equals(password));
    }
}
