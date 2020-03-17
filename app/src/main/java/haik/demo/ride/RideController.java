package haik.demo.ride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RideController {

    @Autowired
    RideService rideService;

    @GetMapping("/createride")
    public String newRide(Model model, RideService rideService ){
            model.addAttribute("createRide", rideService);
        return "createRide";
    }
}
