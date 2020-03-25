package haik.demo.ride;

import haik.demo.user.User;
import haik.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.sql.DataSource;
import java.security.Principal;


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
        ride.setDriver(userRepository.findByEmail(email));
        rideRepository.save(ride);
        return "redirect:/myrides";
    }

    @GetMapping("/rides")
    public String getRides(Model model) {
        Iterable<Ride> allRides = rideRepository.findAll();
        model.addAttribute("rides", allRides);
        return "rides";
    }

    @GetMapping("/myrides")
    public String showMyRides(Model model, Principal principal) {
        String email = principal.getName();
        Iterable<Ride> myRidesList = rideRepository.findAllByDriver(userRepository.findByEmail(email));
        model.addAttribute("myrides", myRidesList);
        return "myrides";
    }

    //er ikke ferdig, funker ikke enda
    @GetMapping("/confirmride")
    public String confirmTrip(User rideid, Model model) {
        model.addAttribute("confirmride", rideRepository.findAllByDriver(rideid));
        return "confirmride";
    }

}
