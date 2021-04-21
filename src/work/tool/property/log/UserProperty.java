package work.tool.property.log;

public class UserProperty {
    public String username = null;
    public String email = null;
    public String password = null;
    public int level = 0;

    public UserProperty() {
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
