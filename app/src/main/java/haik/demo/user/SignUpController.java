package haik.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignUpController {


    @Autowired
    UserRepository userRepository;


    @GetMapping("/register")
    public String showSignupPage(Model model, @ModelAttribute User user){
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("tempUser", user);
        return "register";
    }

    @PostMapping("/register")
    public String registerNewUser(Model model, @ModelAttribute User user, @RequestParam String password ) {
        userRepository.save(user);
        model.addAttribute("tempUser", user);
        model.addAttribute("users", userRepository.findAll());
        return "register";
    }

}
