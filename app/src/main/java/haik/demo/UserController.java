package haik.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
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
            ps.setString(1, "Mirdon");
            ps.setString(2, "Gashi");
            ps.setString(3,"Mirdon_g@hotmail.com");
            ps.setString(4, "123");
            ps.setString(5, "12345667");
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

    @GetMapping("/user/{id}")
    public String userPage(@PathVariable Long id, Model model){
        User user= new User( 1L,"Arild", "Devold", "karo.dev@gmail.com", "test");
        model.addAttribute("user", user);

        return "userPage";
    }



}
