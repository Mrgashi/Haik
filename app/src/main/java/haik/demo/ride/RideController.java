package haik.demo.ride;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("ride", rideRepository.findAll());
        return "createRide";
    }

    @PostMapping("/saveride")
    public String saveRide(@ModelAttribute Ride ride) {
        rideRepository.save(ride);
        return "redirect:/welcome";
//        return "redirect:/user/{id}/myrides"; fremtidig url ? (Karoline)
    }

    @GetMapping("/rides")
    public String getRides(Model model) {
        model.addAttribute("rides", rideRepository.findAll());

        return "rides";
    }

//    //    /user/{id}/myrides - fremtidig url
//    //   må legges inn korrekt JPA-spørring for å hente ut egne turer når db er klar
    @GetMapping("/myrides")
    public String showMyRides(Model model) {
        model.addAttribute("myrides", rideRepository.findAll());

        return "myrides";
    }

}
