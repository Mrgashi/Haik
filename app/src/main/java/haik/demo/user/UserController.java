package haik.demo.user;

import haik.demo.ride.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }


    @GetMapping("/register")
    public String showSignupPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register/sucsessful")
    public String registerNewUser( @ModelAttribute User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/login"; // skal rett til login men må kobles til databasen
    }

    @GetMapping("/login")
    public String logIn() {
        return "login";
    }

    @PostMapping("/postlogin")
    public String postLogIn(String email) {
        User user = userRepository.findByEmail(email);
        Long userId = user.getId();
        return "redirect:/choosestatus/" + userId;
    }



    //knyttes opp brukerside?
    @GetMapping("/user/{id}")
    public User user(@PathVariable Long id) {
        return userRepository.findById(id).get();

    }


    @PostMapping("/user")
    public User create(@RequestBody User user){
        return userRepository.save(user);
    }

    //("/user/{id}/choosestatus") - legg inn når logn inn er klar
    @GetMapping("/choosestatus/{id}")
    public String chooseStatus(@PathVariable Long id, Model model ) {

        model.addAttribute("user", userRepository.findById(id).get());

        return "chooseStatus";
    }

    //metode for når bruker velger å være sjåfør
    // skal denne egentlig være RESTcontroller?
    @PostMapping("/user/{id}/driver")
    public String choseDriver(@PathVariable Long id, User user) {
        // Boolean isDriver = true; kobles opp mot user_ride
        //  .hasRole = driver;  ref. security config, gir tilgang til sidene kun driver har tilgang til
        //userRide.save(user); lagre tilstanden til user i user_ride- databasen

        return "/createRide";
        //return "redirect:/user/{id}/myrides"; fremtidig url
    }

    //metode for når bruker velger å være passasjer
    // skal denne egentlig være RESTcontroller?
    @PostMapping("/user/{id}/passenger")
    public String chosePassenger(@PathVariable Long id, User user) {
        // Boolean isDriver = false; kobles opp mot user_ride
        //  .hasRole = passenger; ref. security config, gir tilgang til sidene kun driver har tilgang til
        //userRide.save(user); lagre tilstanden til user i user_ride- databasen

        return "/rides";
        // return "redirect:/user/{id}/rides"; fremtidig url
    }
}
