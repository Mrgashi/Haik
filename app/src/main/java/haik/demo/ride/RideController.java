package haik.demo.ride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
