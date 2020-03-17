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
// =====  LA TIL DENNE  =====

    @Autowired
    UserRepository userRepository;

    Users users;

    public SignUpController(Users users){
        this.users = users;
    }

    @GetMapping("/signup")
    public String showSignupPage(Model model, @ModelAttribute User user){
        model.addAttribute("users", users.getUsers());
        model.addAttribute("tempUser", user);
        return "signup";
    }

    @PostMapping("/signup")
    public String registerNewUser(Model model, @ModelAttribute User user, @RequestParam String password ) {
        users.addNewUser(user);
        model.addAttribute("tempUser", user);
        model.addAttribute("users", users.getUsers());
        return "login";
    }

}
