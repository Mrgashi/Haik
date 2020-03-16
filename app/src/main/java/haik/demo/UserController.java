package haik.demo;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class UserController {

    public UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
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
