package haik.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class UserController {

    @Autowired
    DataSource dataSource;

    // ===== LA DENNE SOM AUTOWIRED ISTEDENFOR CONSTRUCTOR =======
    @Autowired
    UserRepository userRepository;

    Users tempUsers;


    public void addUser(User user) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO User(firstname, lastname, email, password, phone_number) VALUES (?,?,?,?,?)")) {
            ps.setString(1, "Mirdon");
            ps.setString(2, "Gashi");
            ps.setString(3, "Mirdon_g@hotmail.com");
            ps.setString(4, "123");
            ps.setString(5, "12345667");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }

    // === DISABLER DENNE IMENS JOBBING PÅ SIGNUP ====
    /*
    @GetMapping("/signup")
    public String signUpPage() {
        return "signup";
    }
     */


    @GetMapping("/login")
    public String logIn() {
        return "login";
    }

}
