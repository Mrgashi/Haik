package haik.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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

    @PostMapping("/postlogin")
    public String postLogIn(String email, HttpServletResponse response) {
        User user = userRepository.findByEmail(email);
        Long userId = user.getUser_id();
        Cookie cookie = new Cookie("userId", userId + "");
        //add cookie to response
        response.addCookie(cookie);

        return "redirect:/choosestatus";
    }

//    //Tror ikke denne er i bruk?
//    @GetMapping("/user/{id}")
//    public User user(@PathVariable Long id) {
//        return userRepository.findById(id).get();
//
//    }

    @PostMapping("/user")
    public User create(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/choosestatus")
    public String chooseStatus(Model model, @CookieValue("userId") String userIdString) {
        Long userId = Long.parseLong(userIdString);
        model.addAttribute("user", userRepository.findById(userId).get());

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
