package haik.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.sql.DataSource;

@Controller
public class UserController {

    @Autowired
    DataSource dataSource;

    @Autowired
    UserRepository userRepository;




    @GetMapping("/welcome")
    public String welcomePage() {
        return "welcome";
    }


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


    //("/user/{id}/choosestatus") - legg inn når logn inn er klar
    @GetMapping("/choosestatus")
    public String chooseStatus(Model model) {
        Long id = 1L;
        model.addAttribute("user", userRepository.findById(id).get());

        return "chooseStatus";
    }

    //metode for når bruker velger å være sjåfør
    // skal denne egentlig være RESTcontroller?
    @PostMapping("/user{id}/driver")
    public String choseDriver(@PathVariable Long id, User user) {
        // Boolean isDriver = true; kobles opp mot user_ride
        //  .hasRole = driver;  ref. security config, gir tilgang til sidene kun driver har tilgang til
        //userRide.save(user); lagre tilstanden til user i user_ride- databasen

        return "/createRide";
        //return "redirect:/user/{id}/myrides"; fremtidig url
    }

    //metode for når bruker velger å være passasjer
    // skal denne egentlig være RESTcontroller?
    @PostMapping("/user{id}/passenger")
    public String chosePassenger(@PathVariable Long id, User user) {
        // Boolean isDriver = false; kobles opp mot user_ride
        //  .hasRole = passenger; ref. security config, gir tilgang til sidene kun driver har tilgang til
        //userRide.save(user); lagre tilstanden til user i user_ride- databasen

        return "/rides";
        // return "redirect:/user/{id}/rides"; fremtidig url
    }


}
