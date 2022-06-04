package Utils;

public class User {
    private final String name_;
    private final String login_;
    private final String password_;
    public User(String name, String login, String password)
    {
        name_ = name;
        login_ = login;
        password_ = password;
    }

    public String getName()
    {
        return name_;
    }

    public String getLogin()
    {
        return login_;
    }

    public String getPassword()
    {
        return password_;
    }

}
