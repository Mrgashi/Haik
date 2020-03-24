package haik.demo.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Set;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);

    User findByFirstName(String firstName);

    @Query(nativeQuery = true,value = "select * from user join ride on ride.createdById = user.user_id and user.user_id = 2")
    Set<User> getNameOfDriver();

}
