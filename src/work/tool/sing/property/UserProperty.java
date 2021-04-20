package work.tool.sing.property;

public class UserProperty {
    public String username = null;
    public String email = null;
    public String password = null;
    public int level = 0;

    public UserProperty(String username, String email, String password, int level) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.level = level;
    }

    public UserProperty(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UserProperty(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
