package ng.ourChemo.dtos.responses;

public class UserLoginResponse {

    private String username;
    private boolean loggedIn;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean userLoggedIn) {
        loggedIn = userLoggedIn;
    }
}