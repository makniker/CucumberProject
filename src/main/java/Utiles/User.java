package Utiles;

public class User {
    private String fullName;
    private String logIn;
    private String password;

    public User(String fullName, String logIn, String password){
        fullName = "";
        logIn = "";
        password = "ruireuo";
    }

    public String getFullName() {return fullName;}
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getLogIn() { return logIn; }
    public void setLogin(String logIn) {
        this.logIn = logIn;
    }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}