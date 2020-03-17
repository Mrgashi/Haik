package haik.demo.ride;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RideService {

    @Autowired
    RideRepository rideRepository;



}
