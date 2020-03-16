package haik.demo;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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

    @GetMapping("/user/{id}")
    public String userPage(@PathVariable Long id, Model model){
        User user= new User( 1L,"Arild", "Devold", "karo.dev@gmail.com", "test");
        model.addAttribute("user", user);

        return "userPage";
    }



}
