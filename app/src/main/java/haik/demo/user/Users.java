package haik.demo.user;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Users {

    // ===== TEMP USERS =======
    private List<User> users;

    public Users() {
        users = new ArrayList<>();
        users.add(new User("Karoline", "Devold", "karo@excample.com", "123"));
        users.add(new User("Line", "Kirkhus", "line@excample.com", "123"));
        users.add(new User("Mirdon", "Gashi", "mirdon@excample.com", "123"));
        users.add(new User("Stian", "Lindholm", "stian@excample.com", "123"));
        users.add(new User("Test", "Admin", "test@excample.com", "123"));
    }

    public List<User> getUsers() {
        return users;
    }

    public void addNewUser(User user) {
        users.add(user);
    }

    public void removeTempUsers() {
        users.remove(users.size() - 1);
    }

    public User getTempUser() {
        return users.get(users.size() - 1);
    }
}
