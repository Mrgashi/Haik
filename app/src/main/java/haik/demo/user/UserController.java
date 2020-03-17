package haik.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD:app/src/main/java/haik/demo/user/UserController.java
import org.springframework.web.bind.annotation.GetMapping;
=======
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

>>>>>>> 1fe87a4238b721d1f13a3d914d31339d62db21cc:app/src/main/java/haik/demo/UserController.java

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

    @GetMapping("/user/{id}")
    public String userPage(@PathVariable Long id, Model model){
        User user= new User( 1L,"Arild", "Devold", "karo.dev@gmail.com", "test");
        model.addAttribute("user", user);

        return "userPage";
    }



}
