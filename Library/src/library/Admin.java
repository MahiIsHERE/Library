package library;

public class Admin {
    
    // info:
    private String username = "admin";
    private String password = "library";

    
    // the main constructor
    public Admin(String password) {
        this.password = password;
    }
    
    
    // librarian info:
    // username:
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // password:
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}