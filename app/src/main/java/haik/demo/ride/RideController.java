package haik.demo.ride;

import haik.demo.user.User;
import haik.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.Optional;
import java.util.Set;


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
        User user = userRepository.findByEmail(email);
        Iterable<Ride> myRidesList = user.getRides();
        model.addAttribute("myrides", myRidesList);
        return "myrides";
    }

    //er ikke ferdig, funker ikke enda
    // hent inn id på tur som @Pathvariable
    @GetMapping("/confirmride/{rideId}")
    public String confirmRide(Model model, Principal principal, @PathVariable Long rideId) {
      Optional<Ride> optionalRide = rideRepository.findById(rideId);
        String email = principal.getName();
        User newPassenger = userRepository.findByEmail(email);

        Ride ride = null;
        if(optionalRide.isPresent()) {
            ride = optionalRide.get();
        }

        model.addAttribute("confirmride", ride);
        return "confirmride";
    }


    @PostMapping("/saveUserToRide")
    public String addPassenger(@RequestParam String rideId, Principal principal) {
        String email = principal.getName();
        User newPassenger = userRepository.findByEmail(email);

        Long longRideId = Long.parseLong(rideId);
        Optional<Ride> optionalRide = rideRepository.findById(longRideId);

        Ride ride = null;
        if(optionalRide.isPresent()) {
            ride = optionalRide.get();
            ride.addPassenger(newPassenger);
            ride.setSeatsavailable(ride.getSeatsavailable() - 1);
        }

        rideRepository.save(ride);

        return "redirect:/myrides";
    }

}
