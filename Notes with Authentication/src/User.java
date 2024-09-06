import java.util.HashMap;
import java.util.Map;

public class User {

    private String username;
    private String password;
    private Map<Integer, Note> notes;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.notes = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Map<Integer, Note> getNotes() {
        return notes;
    }
}
