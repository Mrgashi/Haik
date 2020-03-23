package haik.demo;

import haik.demo.ride.Ride;
import haik.demo.ride.RideRepository;
import haik.demo.user.User;
import haik.demo.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RideRepository rideRepository;

//    @Autowired
//    private UserRideRepository userRideRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldFindNull() {
        assertEquals(null, userRepository.findByEmail("test@test.com"));
    }

    @Test
    void shouldFindUser() {
        assertEquals("Mirdon", userRepository.findByEmail("mirdon_g@hotmail.com").getFirstName());
    }

    @Test
    void shoudFindByFirstName() {
        assertEquals("Mirdon", userRepository.findByFirstName("Mirdon").getFirstName());
    }

    @Test
    void shouldFindUserOneById() {
        assertEquals("Mirdon", userRepository.findById(1L).get().getFirstName());
    }

//    @Test
//    void getUserRides() {
//        User user = userRepository.findById(1L).get();
//        List<UserRide> userRides = user.getUserRides();
//        assertEquals(0 , userRides.size());
//    }

    @Test
    void getAvailableSeats () {
        List<Ride> ride = (List<Ride>) rideRepository.findAllBySeatsavailable(5);
        assertEquals("Ullevål Hageby", ride.get(0).getStartlocation());
    }

    @Test
    void shouldFindAllPassengersInARide(){

        // vi må vite om en ride

        Optional<Ride> ride = rideRepository.findById(3L);
        System.out.println(ride);

        if(ride.isPresent()) {
            Ride r = ride.get();
            System.out.println(r.getPassengers());
            assertEquals(3 , r.getPassengers().size());
        }

        // vi må hente alle passasjerer i en bestemt ride
        // vi må printe alle navn på alle passasjerer

    }

//    @Test
//    void shouldFindByRide() {
//        List<User> l = userRepository.findAllByEmailContains("test");
//        assertEquals( "test",userRepository.findByEmail(l));
//
//
//    }
}