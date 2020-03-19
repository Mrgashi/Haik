package haik.demo.security;

import haik.demo.user.User;
import haik.demo.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class MyUserDetailsService implements UserDetailsService  {

    @Autowired
    UserRepository userRepository;


    @Override//epost brukes som username
    public UserDetails loadUserByUsername(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null){
            throw new UsernameNotFoundException(email);
        }
        return new MyUserDetails(user) {
        };
    }
}


