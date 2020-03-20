package haik.demo.ride;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.util.Collections;


@Controller
public class RideController {

    @Autowired
    DataSource dataSource;
    @Autowired
    RideRepository rideRepository;

    @GetMapping("/createride")
    public String newRide(Model model) {

        model.addAttribute("createRide", new Ride());
        return "createRide";
    }

    //    lagrer createdById i httpsession for å huske hvem som er innlogget
    @PostMapping("/saveride")
    public String saveRide(@ModelAttribute Ride ride, HttpSession session) {
        Long userId = (Long)session.getAttribute("userId");
        ride.setCreatedbyid(userId);
        rideRepository.save(ride);
        return "redirect:/myrides";
//        return "redirect:/user/{id}/myrides"; fremtidig url ? (Karoline)
    }

    @GetMapping("/rides")
    public String getRides(Model model) {
        model.addAttribute("rides", rideRepository.findAll());

        return "rides";
    }

    //    viser liste over turer knyttet til en enkelt bruker vha. http-session
    @GetMapping("/myrides")
    public String showMyRides(Model model, HttpSession session) {
        Long userId = (Long)session.getAttribute("userId");
        Iterable<Ride> myRidesList = rideRepository.findAllByCreatedbyid(userId);
        model.addAttribute("myrides", myRidesList);

        return "myrides";
    }

}
