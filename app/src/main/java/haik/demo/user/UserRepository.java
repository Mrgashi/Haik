package haik.demo.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    User findByFirstName(String firstName);

    User findByUsername(String username);

    User findUserById(Long id);
}
