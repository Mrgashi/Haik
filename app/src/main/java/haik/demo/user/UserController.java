package haik.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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
        model.addAttribute("user", userRepository.findById(id).get());

        return "userPage";
    }



}
