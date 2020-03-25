package haik.demo.ride;
import haik.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.Optional;


@Controller
public class RideController {

    @Autowired
    DataSource dataSource;

    @Autowired
    RideRepository rideRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/createride")
    public String newRide(Model model) {

        model.addAttribute("createRide", new Ride());
        return "createRide";
    }

    @PostMapping("/saveride")
    public String saveRide(@ModelAttribute Ride ride, Principal principal) {
        String email = principal.getName();
        ride.setDriver(userRepository.findByEmail(email).get());
        rideRepository.save(ride);
        return "redirect:/myrides";
    }

    @GetMapping("/rides")
    public String getRides(Model model) {
        Iterable<Ride> allRides = rideRepository.findAll();
        model.addAttribute("rides", allRides);
//        model.addAttribute("users", userRepository.findAll());
        return "rides" ;
    }

    //    viser liste over turer knyttet til en enkelt bruker vha. http-session
    @GetMapping("/myrides")
    public String showMyRides(Model model, Principal principal) {
        String email = principal.getName();
        Iterable<Ride> myRidesList = rideRepository.findAllByDriver(userRepository.findByEmail(email));
        model.addAttribute("myrides", myRidesList);
        return "myrides";
    }
}
