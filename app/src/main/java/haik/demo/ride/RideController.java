package haik.demo.ride;

import org.bouncycastle.math.raw.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RideController {

    @Autowired
    DataSource dataSource;
    @Autowired
    RideRepository rideRepository;

    @GetMapping("/createride")
    public String newRide(Model model){
            model.addAttribute("createRide", new Ride());
            model.addAttribute("ride", rideRepository.findAll());
        return "createRide";
    }

    @PostMapping("/saveride")
    public String saveRide(@ModelAttribute Ride ride){
        rideRepository.save(ride);
        return "redirect:/welcome";
//        return "redirect:/user/{id}/myrides"; fremtidig url ? (Karoline)
    }

    @GetMapping("/rides")
    public String getRides(Model model) {
        model.addAttribute("rides", rideRepository.findAll());

        return "rides";
    }
}
