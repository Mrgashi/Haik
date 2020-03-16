package haik.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private UserRepository userRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void shouldFindNull() {
        assertEquals(0, userRepository.findByEmail("mirdon_g@hotmail.com"));
    }

    @Test
    void shoudFindByFirstName() {
        assertEquals("Mirdon", userRepository.findByFirstName("Mirdon"));
    }

}
