package haik.demo.ride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.sql.DataSource;
@Controller
public class RideController {

    @Autowired
    DataSource dataSource;
    @Autowired
    RideRepository rideRepository;

    @GetMapping("/createride")
    public String newRide(Model model, RideRepository rideRepository ){
            model.addAttribute("createRide", rideRepository);
            model.addAttribute("ride", rideRepository.findAll());
        return "createRide";
    }

    @PostMapping("/createride")
    public String createRide(Ride ride){
        rideRepository.save(ride);
        return "redirect:/user/{id}/myrides";
    }
}
