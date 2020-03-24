package haik.demo.ride;
import haik.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;


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

    //    lagrer createdById i httpsession for å huske hvem som er innlogget
    @PostMapping("/saveride")
    public String saveRide(@ModelAttribute Ride ride, @CookieValue("userId") String userIdString) {
        Long userId = Long.parseLong(userIdString);
        ride.setDriver(userRepository.findById(userId).get());
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
    public String showMyRides(Model model, @CookieValue("userId") String userIdString) {
        Long userId = Long.parseLong(userIdString);
        Iterable<Ride> myRidesList = rideRepository.findAllByDriver(userRepository.findById(userId).get());
        model.addAttribute("myrides", myRidesList);

        return "myrides";
    }

}
