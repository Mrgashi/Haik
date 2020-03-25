package haik.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/")
    public String welcomePage() {
        return "welcome";
    }

    @GetMapping("/logout")
    public String logOut(){

        return "rediret:/";
    };

    @GetMapping("/register")
    public String showSignupPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register/successful")
    public String registerNewUser(@ModelAttribute User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String logIn() {
        return "login";
    }

    @GetMapping("/choosestatus")
    public String chooseStatus(Model model, Principal principal) {
        String email = principal.getName();
        model.addAttribute("user", userRepository.findByEmail(email));

        return "chooseStatus";
    }


}
