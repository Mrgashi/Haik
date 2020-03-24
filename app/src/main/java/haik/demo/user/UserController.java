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
        return "redirect:/login"; // skal rett til login men må kobles til databasen
    }

    @GetMapping("/login")
    public String logIn() {
        return "login";
    }



    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/choosestatus")
    public String chooseStatus(Model model, Principal principal) {
        String email = principal.getName();
        model.addAttribute("user", userRepository.findByEmail(email));

        return "chooseStatus";
    }


    //metode for når bruker velger å være sjåfør
    // skal denne egentlig være RESTcontroller?
    @PostMapping("/user/{id}/driver")
    public String choseDriver(@PathVariable Long id, User user) {
        // Boolean isDriver = true; kobles opp mot user_ride
        //userRide.save(user); lagre tilstanden til user i user_ride- databasen

        return "/createRide";
    }

    //metode for når bruker velger å være passasjer
    // skal denne egentlig være RESTcontroller?
    @PostMapping("/user/{id}/passenger")
    public String chosePassenger(@PathVariable Long id, User user) {
        // Boolean isDriver = false; kobles opp mot user_ride
        //userRide.save(user); lagre tilstanden til user i user_ride- databasen

        return "/rides";
        // return "redirect:/user/{id}/rides"; fremtidig url
    }
}
