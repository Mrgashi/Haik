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
        // opprett array med lengde lik ant. passasjerer + plass til sjåfør
        // legg til sjåfør i array på index 0
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
    // hent inn id på tur som @Requestparam
    @GetMapping("/confirmride")
    public String confirmRide(Model model, Long ride_id) {
        ride_id = 1L;
        Set<User> ride = userRepository.getNameOfDriver();
        model.addAttribute("confirmride", ride);
        return "confirmride";
    }

    //
    @PostMapping("/rideconfirmed")
    public String addPassenger() {
        // få imm korrekt ride_id
        //hent ut ledige seter i bilen
        //sett nytt antall ledige seter --> setseats() = getseats -1.
        //lag en verifisering dersom ledige seter == 0, blokker
        //lagre passasjer til passengers.add (user_id)
        //legg til passasjer i array på neste ledige plass
            // 1. passasjer skal på index 1, --> (arr.length - ant. ledige plasser)
                // eks. array lengde 5, sjåfør index 0, første av 4 passasjerer på index (5-4 = 1)

        return "redirect:/myrides";
    }

}
