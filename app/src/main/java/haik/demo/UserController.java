package haik.demo;

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

    public UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser (User user) {
        try (Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO User(firstname, lastname, email, password, phone_number) VALUES (?,?,?,?,?)" ))
        {
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getPhone_number());
            ps.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @GetMapping("/welcome")
    public String welcomePage(){
        return "welcome";
    }

    @GetMapping("/signup")
    public String signUpPage(){
        return "signup";
    }

    @GetMapping("/login")
    public String logIn(){
        return "login";
    }

}
