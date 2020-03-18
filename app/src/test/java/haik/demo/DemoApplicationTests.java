package haik.demo;

import haik.demo.ride.RideRepository;
import haik.demo.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RideRepository rideRepository;


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


}
