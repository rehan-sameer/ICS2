package Objects;

import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private String username;
    private String password;

    // Constructor
    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    // getters for the user

    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    // Ssetters for the user

    public void setName(String name) {
        this.name = name;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    ArrayList<User> users = new ArrayList<>();
}